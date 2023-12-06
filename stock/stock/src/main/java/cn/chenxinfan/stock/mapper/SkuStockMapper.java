package cn.chenxinfan.stock.mapper;

import cn.chenxinfan.stock.domain.dao.SkuStock;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author chenxinfan
 * @site www.chenxinfan.cn
 * @date 2023/12/6 22:15
 */
@Mapper
public interface SkuStockMapper extends BaseMapper<SkuStock> {

    int deductStock(@Param("skuId") String skuId, @Param("deductStockNum") Integer deductStockNum);
}
