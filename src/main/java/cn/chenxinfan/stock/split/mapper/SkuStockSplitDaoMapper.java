package cn.chenxinfan.stock.split.mapper;

import cn.chenxinfan.stock.domain.dao.split.SkuStockSplit;

public interface SkuStockSplitDaoMapper {

    int deleteByPrimaryKey(Long id);

    Long insert(SkuStockSplit record);

    Long insertSelective(SkuStockSplit record);

    SkuStockSplit selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SkuStockSplit record);

    int updateByPrimaryKey(SkuStockSplit record);

    int deductStock(String skuId,  Integer deductStockNum);

}