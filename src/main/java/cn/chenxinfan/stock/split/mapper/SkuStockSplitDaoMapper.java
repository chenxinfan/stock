package cn.chenxinfan.stock.split.mapper;

import cn.chenxinfan.stock.datasource.annotation.DbRoute;
import cn.chenxinfan.stock.datasource.annotation.DbSplitKey;
import cn.chenxinfan.stock.domain.dao.split.SkuStockSplitDao;
import org.apache.ibatis.annotations.Param;

public interface SkuStockSplitDaoMapper {

    @DbRoute
    int deleteByPrimaryKey(@DbSplitKey String skuId, Integer id);

    @DbRoute
    int insert(@DbSplitKey(splitKey = "skuId") SkuStockSplitDao record);

    @DbRoute
    int insertSelective(@DbSplitKey(splitKey = "skuId") SkuStockSplitDao record);

    @DbRoute
    SkuStockSplitDao selectByPrimaryKey(@DbSplitKey String skuId, Integer id);

    @DbRoute
    int updateByPrimaryKeySelective(@DbSplitKey(splitKey = "skuId") SkuStockSplitDao record);

    @DbRoute
    int updateByPrimaryKey(@DbSplitKey(splitKey = "skuId") SkuStockSplitDao record);

    @DbRoute
    int deductStock(@DbSplitKey @Param("skuId") String skuId, @Param("deductStockNum") Integer deductStockNum);

}