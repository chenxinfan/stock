package cn.chenxinfan.stock.datasource.util;

import lombok.extern.slf4j.Slf4j;

/**
 * @author chenxinfan
 * @site www.chenxinfan.cn
 * @date 2023/12/10 16:17
 */
@Slf4j
public class DbTableIndexUtil {

    private static ThreadLocal<String> dbTableThreadLocal = new ThreadLocal<>();

    public static String getTableIndex() {
        String tableIndex = dbTableThreadLocal.get();
        log.info("DbTableIndexUtil.getTableIndex tableIndex:{}", tableIndex);
        return tableIndex;
    }

    public static void setTableIndex(String tableIndex) {
        dbTableThreadLocal.set(tableIndex);
    }

    public static void remove() {
        dbTableThreadLocal.remove();
    }
}
