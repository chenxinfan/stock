package cn.chenxinfan.stock.datasource.annotation;

import java.lang.annotation.*;

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
//@Inherited // 就是说如果某个类使用了被@Inherited 修饰的注解，则其子类将自动具有该注解
public @interface DbSplitKey {
    String splitKey() default ""; //标记splitkey的名称
}
