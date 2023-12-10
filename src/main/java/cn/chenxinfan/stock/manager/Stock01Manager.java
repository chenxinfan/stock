package cn.chenxinfan.stock.manager;

import cn.chenxinfan.stock.domain.bo.StockBo;

/**
 * @author chenxinfan
 * @site www.chenxinfan.cn
 * @date 2023/12/6 22:32
 */
public interface Stock01Manager {
    void deductStock(StockBo stockBo);
}
