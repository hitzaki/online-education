package com.git.hitzaki.education.common.exception;

import lombok.Getter;

/**
 * 中台通用异常
 * @author hitzaki
 */
@Getter
public class CommonBizException extends RuntimeException {

    private String errMessage;

    private Integer errCode;

    public CommonBizException() {
        super();
    }

    public CommonBizException(String message) {
        super(message);
        this.errMessage = message;
        this.errCode = 50000;
    }

    public static void cast(String errMessage){
        throw new CommonBizException(errMessage);
    }
    public static void cast(CommonError commonError){
        throw new CommonBizException(commonError.getErrMessage());
    }
}
