package cn.chenxinfan.stock.datasource.config;

import lombok.Data;

/**
 * 数据库数据源相关配置参数
 *
 * @author chenxinfan
 * @site www.chenxinfan.cn
 * @date 2023/12/13 22:18
 */
@Data
public class DataSourceConfig {

    /**
     * todo 数据库个数
     */
    private String dbNum;

    /**
     * 库名前缀
     */
    private String dbNameprefix;

    /**
     * 库名格式
     */
    private String dbNameFormat;

    /**
     * todo 表的个数
     */
    private String tableNum;

    /**
     * 分表表名格式
     */
    private String tableNameFormat;
}
