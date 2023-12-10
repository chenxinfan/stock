package cn.chenxinfan.stock.datasource.domain;

import cn.chenxinfan.stock.datasource.util.DbTableIndexUtil;

/**
 * @author chenxinfan
 * @site www.chenxinfan.cn
 * @date 2023/12/10 16:15
 */
public class BaseDao {

    private String tableIndex;

    public String getTableIndex() {
        return DbTableIndexUtil.getTableIndex();
    }

    public void setTableIndex(String tableIndex) {
        this.tableIndex = tableIndex;
    }
}
