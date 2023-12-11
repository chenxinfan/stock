package cn.chenxinfan.stock;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = {"cn.chenxinfan.stock.mapper", "cn.chenxinfan.stock.split.mapper"})
@SpringBootApplication
public class StockApplication {

    public static void main(String[] args) {
        SpringApplication.run(StockApplication.class, args);
    }

}
