package cn.chenxinfan.stock.split.dao;

import cn.chenxinfan.stock.domain.dao.split.TransactionCodeSplit;

/**
 * @author chenxinfan
 * @site www.chenxinfan.cn
 * @date 2023/12/12 22:38
 */
public interface TransactionCodeSplitDao {

    int deleteByPrimaryKey(String skuId, Long id);

    Long insert(TransactionCodeSplit record);

    Long insertSelective(TransactionCodeSplit record);

    TransactionCodeSplit selectByPrimaryKey(String skuId, Long id);

    int updateByPrimaryKeySelective(TransactionCodeSplit record);

    int updateByPrimaryKey(TransactionCodeSplit record);
}
