package cn.chenxinfan.stock.split.mapper;

import cn.chenxinfan.stock.datasource.annotation.DbRoute;
import cn.chenxinfan.stock.datasource.annotation.DbSplitKey;
import cn.chenxinfan.stock.domain.dao.split.TransactionCodeSplitDao;

public interface TransactionCodeSplitDaoMapper {

    @DbRoute
    int deleteByPrimaryKey(@DbSplitKey String skuId, Integer id);

    @DbRoute
    int insert(@DbSplitKey(splitKey = "skuId") TransactionCodeSplitDao record);

    @DbRoute
    int insertSelective(@DbSplitKey(splitKey = "skuId") TransactionCodeSplitDao record);

    @DbRoute
    TransactionCodeSplitDao selectByPrimaryKey(@DbSplitKey String skuId, Integer id);

    @DbRoute
    int updateByPrimaryKeySelective(@DbSplitKey(splitKey = "skuId") TransactionCodeSplitDao record);

    @DbRoute
    int updateByPrimaryKey(@DbSplitKey(splitKey = "skuId") TransactionCodeSplitDao record);
}