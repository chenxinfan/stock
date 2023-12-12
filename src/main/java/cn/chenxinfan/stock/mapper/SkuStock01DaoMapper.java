package cn.chenxinfan.stock.mapper;

import cn.chenxinfan.stock.domain.dao.SkuStock;
import org.apache.ibatis.annotations.Param;

public interface SkuStock01DaoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SkuStock record);

    int insertSelective(SkuStock record);

    SkuStock selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SkuStock record);

    int updateByPrimaryKey(SkuStock record);

    int deductStock(@Param("skuId") String skuId, @Param("deductStockNum") Integer deductStockNum);

}