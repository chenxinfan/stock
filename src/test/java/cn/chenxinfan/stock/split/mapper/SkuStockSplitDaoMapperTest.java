package cn.chenxinfan.stock.split.mapper;

import cn.chenxinfan.stock.BaseTest;
import cn.chenxinfan.stock.domain.dao.split.SkuStockSplitDao;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author chenxinfan
 * @site www.chenxinfan.cn
 * @date 2023/12/11 22:26
 */
public class SkuStockSplitDaoMapperTest extends BaseTest {

    @Autowired
    private SkuStockSplitDaoMapper skuStockSplitDaoMapper;

    @Test
    public void insertTest(){
        SkuStockSplitDao skuStockSplitDao = new SkuStockSplitDao();
        skuStockSplitDao.setSkuId("11");
        skuStockSplitDao.setStock(100);
        skuStockSplitDaoMapper.insert(skuStockSplitDao);

//        skuStockSplitDaoMapper.deductStock("111", 100);
    }

}
