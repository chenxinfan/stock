package cn.chenxinfan.stock.service.impl.db;

import cn.chenxinfan.stock.BaseTest;
import cn.chenxinfan.stock.result.StockResult;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author chenxinfan
 * @site www.chenxinfan.cn
 * @date 2023/12/6 23:00
 */
public class StockDbServiceImplTest extends BaseTest {

    @Autowired
    private StockDbServiceImpl service;

    @Test
    public void deductStock() {
        StockResult stockResult = service.deductStock("1000", "1", 10);
        System.out.println(stockResult);
    }
}
