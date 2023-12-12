package cn.chenxinfan.stock.split.mapper;

import cn.chenxinfan.stock.BaseTest;
import cn.chenxinfan.stock.domain.dao.split.SkuStockSplit;
import cn.chenxinfan.stock.split.dao.SkuStockSplitDao;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author chenxinfan
 * @site www.chenxinfan.cn
 * @date 2023/12/11 22:26
 */
public class SkuStockSplitDaoMapperTest extends BaseTest {

    @Autowired
    private SkuStockSplitDao skuStockSplitDaoMapper;

    @Test
    public void insertTest() {
        SkuStockSplit skuStockSplitDao = new SkuStockSplit();
        skuStockSplitDao.setSkuId("14");
        skuStockSplitDao.setStock(100);
        skuStockSplitDaoMapper.insert(skuStockSplitDao);
    }

}
