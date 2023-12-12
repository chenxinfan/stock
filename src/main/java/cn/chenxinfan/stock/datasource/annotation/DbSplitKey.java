package cn.chenxinfan.stock.datasource.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用来确定分表的注解
 * 只能作用于参数
 *
 * @author chenxinfan
 * @site www.chenxinfan.cn
 * @date 2023/12/10 16:41
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface DbSplitKey {
    //标记splitkey的名称
    String splitKey() default "";
}
