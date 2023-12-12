package cn.chenxinfan.stock.split.dao.impl;

import cn.chenxinfan.stock.datasource.annotation.DbRoute;
import cn.chenxinfan.stock.datasource.annotation.DbSplitKey;
import cn.chenxinfan.stock.domain.dao.split.SkuStockSplit;
import cn.chenxinfan.stock.split.dao.SkuStockSplitDao;
import cn.chenxinfan.stock.split.mapper.SkuStockSplitDaoMapper;
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
public class SkuStockSplitDaoImpl implements SkuStockSplitDao {

    @Autowired
    private SkuStockSplitDaoMapper skuStockSplitDaoMapper;

    @DbRoute
    @Override
    public int deleteByPrimaryKey(@DbSplitKey String skuId, Long id) {
        return skuStockSplitDaoMapper.deleteByPrimaryKey(id);
    }

    @DbRoute
    @Override
    public Long insert(@DbSplitKey(splitKey = "skuId") SkuStockSplit record) {
        return skuStockSplitDaoMapper.insert(record);
    }

    @DbRoute
    @Override
    public Long insertSelective(@DbSplitKey(splitKey = "skuId") SkuStockSplit record) {
        return skuStockSplitDaoMapper.insertSelective(record);
    }

    @DbRoute
    @Override
    public SkuStockSplit selectByPrimaryKey(@DbSplitKey String skuId, Long id) {
        return skuStockSplitDaoMapper.selectByPrimaryKey(id);
    }

    @DbRoute
    @Override
    public int updateByPrimaryKeySelective(@DbSplitKey(splitKey = "skuId") SkuStockSplit record) {
        return skuStockSplitDaoMapper.updateByPrimaryKeySelective(record);
    }

    @DbRoute
    @Override
    public int updateByPrimaryKey(@DbSplitKey(splitKey = "skuId") SkuStockSplit record) {
        return skuStockSplitDaoMapper.updateByPrimaryKey(record);
    }

    @DbRoute
    @Override
    public int deductStock(@DbSplitKey String skuId, Integer deductStockNum) {
        return skuStockSplitDaoMapper.deductStock(skuId, deductStockNum);
    }
}
