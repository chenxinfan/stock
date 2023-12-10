package cn.chenxinfan.stock.mapper;

import cn.chenxinfan.stock.BaseTest;
import cn.chenxinfan.stock.domain.dao.TransactionCodeDao;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author chenxinfan
 * @site www.chenxinfan.cn
 * @date 2023/12/6 22:17
 */
public class SkuOrderMapperTest extends BaseTest {

    @Autowired
    private TransactionCodeDaoMapper skuOrderMapper;

    @Test
    public void testInsert() {
        TransactionCodeDao skuOrder = new TransactionCodeDao();
        skuOrder.setSkuId("1");
        skuOrder.setTransactionCode("100");
        skuOrderMapper.insert(skuOrder);
    }
}
