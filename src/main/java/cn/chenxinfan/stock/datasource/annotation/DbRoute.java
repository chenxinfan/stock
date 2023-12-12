package cn.chenxinfan.stock.datasource.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 数据库路由注解
 * 需要配合DbSplitKey注解使用
 *
 * @author chenxinfan
 * @site www.chenxinfan.cn
 * @date 2023/12/10 18:17
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface DbRoute {
}
