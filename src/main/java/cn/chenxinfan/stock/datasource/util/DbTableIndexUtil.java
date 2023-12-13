package cn.chenxinfan.stock.datasource.util;

import lombok.extern.slf4j.Slf4j;

/**
 * @author chenxinfan
 * @site www.chenxinfan.cn
 * @date 2023/12/10 16:17
 */
@Slf4j
public class DbTableIndexUtil {

    private static ThreadLocal<String> dbTheadLocal = new ThreadLocal<>();
    private static ThreadLocal<String> tableThreadLocal = new ThreadLocal<>();


    public static String getDbIndex() {
        String dbIndex = dbTheadLocal.get();
        log.info("DbTableIndexUtil.getDbIndex dbIndex:{}", dbIndex);
        return dbIndex;
    }

    public static void setDbIndex(String dbIndex) {
        dbTheadLocal.set(dbIndex);
    }

    public static void removeDbIndex() {
        dbTheadLocal.remove();
    }


    public static String getTableIndex() {
        String tableIndex = tableThreadLocal.get();
        log.info("DbTableIndexUtil.getTableIndex tableIndex:{}", tableIndex);
        return tableIndex;
    }

    public static void setTableIndex(String tableIndex) {
        tableThreadLocal.set(tableIndex);
    }

    public static void removeTableIndex() {
        tableThreadLocal.remove();
    }
}
