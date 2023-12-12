package cn.chenxinfan.stock.domain.dao;

import lombok.Data;

@Data
public class SkuStock {

    private Long id;

    private String skuId;

    private Integer stock;
}