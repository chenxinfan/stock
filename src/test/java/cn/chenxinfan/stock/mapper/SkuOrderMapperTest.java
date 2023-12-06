package cn.chenxinfan.stock.mapper;

import cn.chenxinfan.stock.BaseTest;
import cn.chenxinfan.stock.domain.dao.SkuOrder;
import cn.chenxinfan.stock.domain.dao.SkuStock;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author chenxinfan
 * @site www.chenxinfan.cn
 * @date 2023/12/6 22:17
 */
public class SkuOrderMapperTest extends BaseTest {

    @Autowired
    private SkuOrderMapper skuOrderMapper;

    @Test
    public void testInsert() {
        SkuOrder skuOrder = new SkuOrder();
        skuOrder.setSkuId("1");
        skuOrder.setOrderId(100L);
        skuOrderMapper.insert(skuOrder);
    }
}
