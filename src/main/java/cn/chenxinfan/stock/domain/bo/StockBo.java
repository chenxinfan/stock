package cn.chenxinfan.stock.domain.bo;

import lombok.Data;

/**
 * @author chenxinfan
 * @site www.chenxinfan.cn
 * @date 2023/12/6 22:32
 */
@Data
public class StockBo {

    private Long orderId;

    private String skuId;

    private Integer deductStockNum;
}
