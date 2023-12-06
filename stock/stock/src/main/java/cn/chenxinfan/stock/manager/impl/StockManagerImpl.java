package cn.chenxinfan.stock.manager.impl;

import cn.chenxinfan.stock.domain.bo.StockBo;
import cn.chenxinfan.stock.domain.dao.SkuOrder;
import cn.chenxinfan.stock.manager.StockManager;
import cn.chenxinfan.stock.mapper.SkuOrderMapper;
import cn.chenxinfan.stock.mapper.SkuStockMapper;
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
public class StockManagerImpl implements StockManager {

    @Autowired
    private SkuOrderMapper skuOrderMapper;

    @Autowired
    private SkuStockMapper skuStockMapper;

    @Override
    @Transactional
    public void deductStock(StockBo stockBo) {
        //1，扣减库存防重码
        SkuOrder skuOrder = new SkuOrder();
        skuOrder.setOrderId(stockBo.getOrderId());
        skuOrder.setSkuId(stockBo.getSkuId());
        if (skuOrderMapper.insert(skuOrder) != 1) {
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
