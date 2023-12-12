package cn.chenxinfan.stock.mapper;

import cn.chenxinfan.stock.BaseTest;
import cn.chenxinfan.stock.domain.dao.SkuStock;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author chenxinfan
 * @site www.chenxinfan.cn
 * @date 2023/12/6 22:17
 */
public class SkuStockMapperTest extends BaseTest {

    @Autowired
    private SkuStock01DaoMapper skuStockMapper;

    @Test
    public void testInsert() {
        SkuStock skuStock = new SkuStock();
        skuStock.setSkuId("2");
        skuStock.setStock(100);
        skuStockMapper.insert(skuStock);
    }

    @Test
    public void testDeductStock() {
        int i = skuStockMapper.deductStock("1", 100);
        System.out.println(i);
    }

}
