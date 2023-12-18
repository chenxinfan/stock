package cn.chenxinfan.stock.datasource;

import cn.chenxinfan.stock.datasource.config.DataSourceProperty;
import cn.chenxinfan.stock.datasource.util.DbTableIndexUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 动态数据源
 *
 * @author chenxinfan
 * @site www.chenxinfan.cn
 * @date 2023/12/13 23:15
 */
@Slf4j
public class DynamicDataSource extends AbstractRoutingDataSource {

    private DataSourceProperty dataSourceConfig;

    @Override
    protected Object determineCurrentLookupKey() {
        if (StringUtils.isBlank(DbTableIndexUtil.getDbIndex())) {
            log.info("DynamicDataSource.determineCurrentLookupKey dataSourceName is null");
            return null;
        }
        String dataSourceName = dataSourceConfig.getDbNameprefix() + DbTableIndexUtil.getDbIndex();
        log.info("DynamicDataSource.determineCurrentLookupKey dataSourceName:{}", dataSourceName);
        return dataSourceName;
    }

    public void setDataSourceConfig(DataSourceProperty dataSourceConfig) {
        this.dataSourceConfig = dataSourceConfig;
    }
}
