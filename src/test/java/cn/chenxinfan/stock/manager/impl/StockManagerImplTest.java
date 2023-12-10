package cn.chenxinfan.stock.manager.impl;

import cn.chenxinfan.stock.BaseTest;
import cn.chenxinfan.stock.domain.bo.StockBo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author chenxinfan
 * @site www.chenxinfan.cn
 * @date 2023/12/10 17:12
 */
public class StockManagerImplTest extends BaseTest {

    @Autowired
    private Stock01ManagerImpl stockManager;

    @Test
    public void deductStockTest() {
        StockBo stockBo = new StockBo();
        stockBo.setSkuId("1001");
        stockManager.deductStock(stockBo);
    }
}
