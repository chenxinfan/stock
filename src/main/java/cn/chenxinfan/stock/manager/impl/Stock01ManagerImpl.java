package cn.chenxinfan.stock.manager.impl;

import cn.chenxinfan.stock.domain.bo.StockBo;
import cn.chenxinfan.stock.domain.dao.TransactionCode;
import cn.chenxinfan.stock.manager.Stock01Manager;
import cn.chenxinfan.stock.mapper.SkuStock01DaoMapper;
import cn.chenxinfan.stock.mapper.TransactionCode01DaoMapper;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author chenxinfan
 * @site www.chenxinfan.cn
 * @date 2023/12/6 22:35
 */
@Slf4j
@Service
public class Stock01ManagerImpl implements Stock01Manager {

    @Autowired
    private TransactionCode01DaoMapper skuOrderMapper;

    @Autowired
    private SkuStock01DaoMapper skuStockMapper;

    @Override
    @Transactional
    public void deductStock(StockBo stockBo) {
        //1，扣减库存防重码
        TransactionCode skuOrder = new TransactionCode();
        skuOrder.setTransactionCode(stockBo.getTransactionCode());
        skuOrder.setSkuId(stockBo.getSkuId());
        if (skuOrderMapper.insertSelective(skuOrder) != 1) {
            log.error("skuOrderMapper.insert error! skuOrder:{}", JSONObject.toJSONString(skuOrder));
            throw new RuntimeException("skuOrderMapper.insert error!");
        }
        //2，扣减库存
        if (skuStockMapper.deductStock(stockBo.getSkuId(), stockBo.getDeductStockNum()) != 1) {
            log.error("skuStockMapper.deductStock! skuId:{} deductStockNum:{}", stockBo.getSkuId(), stockBo.getDeductStockNum());
            throw new RuntimeException("skuStockMapper.deductStock!");
        }
    }
}
