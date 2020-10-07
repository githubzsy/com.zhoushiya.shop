package com.zhoushiya.shop.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * @author zhoushiya
 * @date 2020/9/26 16:33
 */
@Data
@AllArgsConstructor
public class CommonResult<T> {
    private HttpStatus code;
    private String message;
    private T data;

    private CommonResult() {

    }

    public CommonResult(HttpStatus code, String message) {
        this(code, message, null);
    }

    /**
     * 获取正常返回的CommonResult
     * @param data
     * @return
     */
    public static final CommonResult getOKResult(Object data) {
        return new CommonResult(HttpStatus.OK, "操作成功", data);
    }

    public static final CommonResult tooManyRequestsResult = CommonResultInstance.tooManyRequestsResult;


    static class CommonResultInstance {
        private static CommonResult tooManyRequestsResult = new CommonResult(HttpStatus.TOO_MANY_REQUESTS, "您的请求过于频繁，请稍后再试!");
    }
}
