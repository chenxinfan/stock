package cn.chenxinfan.stock.datasource;

import cn.chenxinfan.stock.datasource.config.DataSourceConfig;
import cn.chenxinfan.stock.datasource.util.DbTableIndexUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;

/**
 * 动态数据源
 *
 * @author chenxinfan
 * @site www.chenxinfan.cn
 * @date 2023/12/13 23:15
 */
@Component
public class DynamicDataSource extends AbstractRoutingDataSource {

    @Autowired
    private DataSourceConfig dataSourceConfig;

    @Override
    protected Object determineCurrentLookupKey() {
        if (StringUtils.isBlank(DbTableIndexUtil.getDbIndex())) {
            return dataSourceConfig.getDbDefaultNume();
        }
        return String.format(dataSourceConfig.getDbNameFormat(), DbTableIndexUtil.getDbIndex());
    }
}
