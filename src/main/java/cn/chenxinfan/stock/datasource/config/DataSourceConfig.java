package cn.chenxinfan.stock.datasource.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 数据库数据源相关配置参数
 *
 * @author chenxinfan
 * @site www.chenxinfan.cn
 * @date 2023/12/13 22:18
 */
@Data
@Component
public class DataSourceConfig {

    /**
     * 数据库个数
     */
    @Value("${dataSource.config.dbNum}")
    private Integer dbNum;

    /**
     * 库名格式
     */
    @Value("${dataSource.config.dbNameFormat}")
    private String dbNameFormat;

    /**
     * 默认数据库名称
     */
    @Value("${dataSource.config.dbDefaultNume}")
    private String dbDefaultNume;

    /**
     * 表的个数
     */
    @Value("${dataSource.config.tableNum}")
    private Integer tableNum;

    /**
     * 分表表名格式
     */
    @Value("${dataSource.config.tableNameFormat}")
    private String tableNameFormat;
}
