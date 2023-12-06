package cn.chenxinfan.stock.service;

import cn.chenxinfan.stock.result.StockResult;

/**
 * @author chenxinfan
 * @site www.chenxinfan.cn
 * @date 2023/12/6 21:30
 */
public interface StockService {

    StockResult deductStock(Long orderId, String skuId, Integer deductStockNum);
}
