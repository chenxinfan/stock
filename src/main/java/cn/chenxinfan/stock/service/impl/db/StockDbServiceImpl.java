package cn.chenxinfan.stock.service.impl.db;

import cn.chenxinfan.stock.domain.bo.StockBo;
import cn.chenxinfan.stock.enums.StockCodeEnum;
import cn.chenxinfan.stock.manager.Stock01Manager;
import cn.chenxinfan.stock.mapper.SkuStock01DaoMapper;
import cn.chenxinfan.stock.result.StockResult;
import cn.chenxinfan.stock.service.StockService;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

/**
 * 方案一：数据库：使用数据库事务保证数据争取性，准确性最高，并发量高时性能较差
 * 单库单表
 *
 * @author chenxinfan
 * @site www.chenxinfan.cn
 * @date 2023/12/6 21:33
 */
@Slf4j
@Service
public class StockDbServiceImpl implements StockService {

    @Autowired
    private SkuStock01DaoMapper skuStockMapper;

    @Autowired
    private Stock01Manager stockManager;

    @Override
    public StockResult deductStock(String transactionCode, String skuId, Integer deductStockNum) {
        //todo 1，查询库存


        //2，扣减库存
        StockBo stockBo = new StockBo();
        stockBo.setTransactionCode(transactionCode);
        stockBo.setSkuId(skuId);
        stockBo.setDeductStockNum(deductStockNum);
        try {
            stockManager.deductStock(stockBo);
        } catch (DuplicateKeyException e) {
            log.error("stockManager.deductStock DuplicateKeyException! StockBo:{}", JSONObject.toJSONString(stockBo));
            return StockResult.buildFail(StockCodeEnum.repeat_deduct);
        } catch (Exception e) {
            log.error("stockManager.deductStock Exception! StockBo:{}", JSONObject.toJSONString(stockBo));
            return StockResult.buildFail(StockCodeEnum.system_error);
        }
        return StockResult.buildSuccess();
    }
}
