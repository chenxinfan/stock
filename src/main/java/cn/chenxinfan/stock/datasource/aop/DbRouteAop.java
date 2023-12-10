package cn.chenxinfan.stock.datasource.aop;

import cn.chenxinfan.stock.datasource.annotation.DbSplitKey;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author chenxinfan
 * @site www.chenxinfan.cn
 * @date 2023/12/10 18:21
 */
@Slf4j
@Aspect
@Component
public class DbRouteAop {

    @Pointcut("@annotation(cn.chenxinfan.stock.datasource.annotation.DbRoute)")
    public void pointcut() {
    }

    @Around("pointcut()")
    public void doAround(ProceedingJoinPoint jointPoint) throws Throwable {
        // 获取当前访问的class类及类名
        Class<?> clazz = jointPoint.getTarget().getClass();
        String clazzName = jointPoint.getTarget().getClass().getName();

        // 获取访问的方法名
        String methodName = jointPoint.getSignature().getName();
        // 获取方法所有参数及其类型
        Object[] argObjects = jointPoint.getArgs();
        Class[] argClazzS = ((MethodSignature) jointPoint.getSignature()).getParameterTypes();
        // 获取访问的方法对象
        Method method = clazz.getDeclaredMethod(methodName, argClazzS);
        //获取当前方法上面的注解
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        if (parameterAnnotations.length == 0 || parameterAnnotations[0].length == 0) {
            String errmsg = String.format("className:%s methodName:%s not find DbSplitKey annotation", clazzName, methodName);
            log.error(errmsg);
            throw new RuntimeException(errmsg);
        }

        String splitKeyValue = getSplitkeyValue(argObjects, parameterAnnotations);
        if (StringUtils.isBlank(splitKeyValue)) {
            String errmsg = String.format("className:%s methodName:%s splitKeyValue is blank", clazzName, methodName);
            log.error(errmsg);
            throw new RuntimeException(errmsg);
        }

        log.info("DbRouteAop splitKeyValue:{}", splitKeyValue);
//
//        if (method.isAnnotationPresent(DbRoute.class)) {
//            Annotation[][] parameterAnnotations = method.getParameterAnnotations();
//            for (Annotation[] annotationArray : parameterAnnotations) {
//                System.out.println("asd");
//            }
//        }

//        // 判断当前访问的方法是否存在指定注解
//        if (method.isAnnotationPresent(AopDemoAnnotation.class)) {
//            AopDemoAnnotation annotation = method.getAnnotation(AopDemoAnnotation.class);
//
//            // 获取注解标识值与注解描述
//            String value = annotation.value();
//            String desc = annotation.description();
//
//            // 执行目标方法
//            Object proceed = jointPoint.proceed();
//            System.out.println("打印方法是执行返回结果：" + proceed.toString());
//        }
    }

    /**
     * 获取splitKey对应的value值
     *
     * @param argObjects
     * @param parameterAnnotations
     * @return
     */
    private String getSplitkeyValue(Object[] argObjects, Annotation[][] parameterAnnotations) {
        Pair<String, Object> pairObject = getSplitKeyMarkObject(argObjects, parameterAnnotations);
        if (pairObject == null) {
            log.error("DbRouteAop.getSplitKeyMarkObject return is null. argObjects:{} parameterAnnotations:{}", JSONObject.toJSONString(argObjects), JSONObject.toJSONString(parameterAnnotations));
            return null;
        }
        String splitKeyName = pairObject.getLeft();
        Object splitKeyObject = pairObject.getRight();
        if (StringUtils.isBlank(splitKeyName)) {
            return splitKeyObject.toString();
        }
        Field[] declaredFields = splitKeyObject.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            String name = field.getName();
            if (splitKeyName.equals(name)) {
                field.setAccessible(true);
                try {
                    return (String) field.get(splitKeyObject);
                } catch (Throwable e) {
                    log.error("DbRouteAop.getSplitkeyValue Throwable!", e);
                }
            }
        }
        return null;
    }

    /**
     * 获取被 @DbSplitKey注解标记的参数对象
     *
     * @return
     */
    private Pair<String, Object> getSplitKeyMarkObject(Object[] argObjects, Annotation[][] parameterAnnotations) {
        for (int index = 0; index < parameterAnnotations.length; index++) {
            Annotation[] parameterAnnotation = parameterAnnotations[index];
            for (Annotation annotation : parameterAnnotation) {
                if (annotation instanceof DbSplitKey) {
                    DbSplitKey dbSplitKey = (DbSplitKey) annotation;
                    return Pair.of(dbSplitKey.splitKey(), argObjects[index]);
                }
            }
        }
        return null;
    }
}
