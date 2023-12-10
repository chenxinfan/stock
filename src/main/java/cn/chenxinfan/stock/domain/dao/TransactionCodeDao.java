package cn.chenxinfan.stock.domain.dao;

import lombok.Data;

@Data
public class TransactionCodeDao {
    private Long id;

    private String transactionCode;

    private String skuId;
}