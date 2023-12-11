package cn.chenxinfan.stock.domain.dao.split;

import cn.chenxinfan.stock.datasource.domain.split.BaseSplitDao;
import lombok.Data;

@Data
public class TransactionCodeSplitDao extends BaseSplitDao {

    private Long id;

    private String transactionCode;

    private String skuId;
}