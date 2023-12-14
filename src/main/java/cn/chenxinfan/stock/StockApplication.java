package cn.chenxinfan.stock;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.ImportResource;

@MapperScan(basePackages = {"cn.chenxinfan.stock.mapper", "cn.chenxinfan.stock.split.mapper"})
//排除DataSourceAutoConfiguration，因为它会读取application.properties文件的spring.datasource.*属性并自动配置单数据源
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@ConfigurationPropertiesScan("cn.chenxinfan.stock")
@ImportResource(value = "classpath:datasource/spring-datasource.xml")
public class StockApplication {

    public static void main(String[] args) {
        SpringApplication.run(StockApplication.class, args);
    }

}
