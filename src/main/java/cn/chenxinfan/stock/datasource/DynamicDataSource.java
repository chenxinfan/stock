package cn.chenxinfan.stock.datasource;

import cn.chenxinfan.stock.datasource.config.DataSourceConfig;
import cn.chenxinfan.stock.datasource.util.DbTableIndexUtil;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 动态数据源
 *
 * @author chenxinfan
 * @site www.chenxinfan.cn
 * @date 2023/12/13 23:15
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    private DataSourceConfig dataSourceConfig;

    @Override
    protected Object determineCurrentLookupKey() {
        return String.format(dataSourceConfig.getDbNameFormat(), DbTableIndexUtil.getDbIndex());
    }

    public void setDataSourceConfig(DataSourceConfig dataSourceConfig) {
        this.dataSourceConfig = dataSourceConfig;
    }
}
