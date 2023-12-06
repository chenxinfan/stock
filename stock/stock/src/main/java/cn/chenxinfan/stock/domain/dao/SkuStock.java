package cn.chenxinfan.stock.domain.dao;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author chenxinfan
 * @site www.chenxinfan.cn
 * @date 2023/12/6 21:49
 */
@Data
@TableName("sku_stock_01")
public class SkuStock {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("sku_id")
    private String skuId;

    @TableField("stock")
    private Integer stock;
}
