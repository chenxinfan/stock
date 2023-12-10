package cn.chenxinfan.stock.mapper;

import cn.chenxinfan.stock.domain.dao.SkuStockDao;
import org.apache.ibatis.annotations.Param;

public interface SkuStock01DaoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SkuStockDao record);

    int insertSelective(SkuStockDao record);

    SkuStockDao selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SkuStockDao record);

    int updateByPrimaryKey(SkuStockDao record);

    int deductStock(@Param("skuId") String skuId, @Param("deductStockNum") Integer deductStockNum);

}