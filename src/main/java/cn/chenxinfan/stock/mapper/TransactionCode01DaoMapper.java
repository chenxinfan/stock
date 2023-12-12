package cn.chenxinfan.stock.mapper;

import cn.chenxinfan.stock.domain.dao.TransactionCode;

public interface TransactionCode01DaoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TransactionCode record);

    int insertSelective(TransactionCode record);

    TransactionCode selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TransactionCode record);

    int updateByPrimaryKey(TransactionCode record);
}