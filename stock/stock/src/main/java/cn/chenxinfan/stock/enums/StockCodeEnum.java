package cn.chenxinfan.stock.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author chenxinfan
 * @site www.chenxinfan.cn
 * @date 2023/12/6 22:52
 */
@Getter
@AllArgsConstructor
public enum StockCodeEnum implements CodeEnum {
    not_enough("00001", "库存不足"),
    repeat_deduct("00002", "重复扣减"),
    system_error("99999", "火爆抢购中"),
    ;
    private String code;
    private String desc;
}
