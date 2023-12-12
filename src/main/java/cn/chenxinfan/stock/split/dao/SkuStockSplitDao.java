package cn.chenxinfan.stock.split.dao;

import cn.chenxinfan.stock.domain.dao.split.SkuStockSplit;

/**
 * @author chenxinfan
 * @site www.chenxinfan.cn
 * @date 2023/12/12 22:38
 */
public interface SkuStockSplitDao {

    int deleteByPrimaryKey(String skuId, Long id);

    Long insert(SkuStockSplit record);

    Long insertSelective(SkuStockSplit record);

    SkuStockSplit selectByPrimaryKey(String skuId, Long id);

    int updateByPrimaryKeySelective(SkuStockSplit record);

    int updateByPrimaryKey(SkuStockSplit record);

    int deductStock(String skuId, Integer deductStockNum);
}
