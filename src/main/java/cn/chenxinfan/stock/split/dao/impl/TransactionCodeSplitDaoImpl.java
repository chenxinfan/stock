package cn.chenxinfan.stock.split.dao.impl;

import cn.chenxinfan.stock.datasource.annotation.DbRoute;
import cn.chenxinfan.stock.datasource.annotation.DbSplitKey;
import cn.chenxinfan.stock.domain.dao.split.TransactionCodeSplit;
import cn.chenxinfan.stock.split.dao.TransactionCodeSplitDao;
import cn.chenxinfan.stock.split.mapper.TransactionCodeSplitDaoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chenxinfan
 * @site www.chenxinfan.cn
 * @date 2023/12/12 22:39
 */
@Slf4j
@Service
public class TransactionCodeSplitDaoImpl implements TransactionCodeSplitDao {

    @Autowired
    private TransactionCodeSplitDaoMapper transactionCodeSplitDaoMapper;

    @DbRoute
    @Override
    public int deleteByPrimaryKey(@DbSplitKey String skuId, Long id) {
        return transactionCodeSplitDaoMapper.deleteByPrimaryKey(id);
    }

    @DbRoute
    @Override
    public Long insert(@DbSplitKey(splitKey = "skuId") TransactionCodeSplit record) {
        return transactionCodeSplitDaoMapper.insert(record);
    }

    @DbRoute
    @Override
    public Long insertSelective(@DbSplitKey(splitKey = "skuId") TransactionCodeSplit record) {
        return transactionCodeSplitDaoMapper.insertSelective(record);
    }

    @DbRoute
    @Override
    public TransactionCodeSplit selectByPrimaryKey(@DbSplitKey String skuId, Long id) {
        return transactionCodeSplitDaoMapper.selectByPrimaryKey(id);
    }

    @DbRoute
    @Override
    public int updateByPrimaryKeySelective(@DbSplitKey(splitKey = "skuId") TransactionCodeSplit record) {
        return transactionCodeSplitDaoMapper.updateByPrimaryKeySelective(record);
    }

    @DbRoute
    @Override
    public int updateByPrimaryKey(@DbSplitKey(splitKey = "skuId") TransactionCodeSplit record) {
        return transactionCodeSplitDaoMapper.updateByPrimaryKey(record);
    }
}
