package cn.chenxinfan.stock.result;

import cn.chenxinfan.stock.enums.CodeEnum;
import lombok.Data;

/**
 * @author chenxinfan
 * @site www.chenxinfan.cn
 * @date 2023/12/6 21:31
 */
@Data
public class StockResult {
    private boolean success;
    private String errorCode;
    private String errorMsg;

    public static StockResult buildSuccess() {
        StockResult stockResult = new StockResult();
        stockResult.setSuccess(true);
        return stockResult;
    }

    public static StockResult buildFail(CodeEnum codeEnum) {
        StockResult stockResult = new StockResult();
        stockResult.setSuccess(false);
        stockResult.setErrorCode(codeEnum.getCode());
        stockResult.setErrorMsg(codeEnum.getDesc());
        return stockResult;
    }
}
