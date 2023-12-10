package cn.chenxinfan.stock.domain.dao.split;

import cn.chenxinfan.stock.datasource.domain.BaseSplitDao;
import lombok.Data;

@Data
public class SkuStockSplitDao extends BaseSplitDao {

    private Long id;

    private String skuId;

    private Integer stock;
}