package com.git.hitzaki.education.common.exception;

import com.git.hitzaki.education.common.constant.RequestCodeConstant;
import com.git.hitzaki.education.common.enums.ExceptionEnum;
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
        this.errCode = RequestCodeConstant.FAIL;
    }

    public CommonBizException(Integer errCode, String message) {
        super(message);
        this.errMessage = message;
        this.errCode = errCode;
    }

    public static void build(String errMessage){
        throw new CommonBizException(errMessage);
    }

    public static void build(ExceptionEnum exceptionEnum){
        throw new CommonBizException(exceptionEnum.getCode(), exceptionEnum.getDescription());
    }
}
