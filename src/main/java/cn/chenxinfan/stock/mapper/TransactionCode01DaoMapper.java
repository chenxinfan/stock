package cn.chenxinfan.stock.mapper;

import cn.chenxinfan.stock.domain.dao.TransactionCodeDao;

public interface TransactionCode01DaoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TransactionCodeDao record);

    int insertSelective(TransactionCodeDao record);

    TransactionCodeDao selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TransactionCodeDao record);

    int updateByPrimaryKey(TransactionCodeDao record);
}