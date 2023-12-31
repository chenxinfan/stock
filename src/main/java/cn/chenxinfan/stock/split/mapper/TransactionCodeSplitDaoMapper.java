package cn.chenxinfan.stock.split.mapper;

import cn.chenxinfan.stock.domain.dao.split.TransactionCodeSplit;

public interface TransactionCodeSplitDaoMapper {
    int deleteByPrimaryKey(Long id);

    Long insert(TransactionCodeSplit record);

    Long insertSelective(TransactionCodeSplit record);

    TransactionCodeSplit selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TransactionCodeSplit record);

    int updateByPrimaryKey(TransactionCodeSplit record);

}