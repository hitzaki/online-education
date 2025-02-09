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
        super(ExceptionEnum.COMMON_EXCEPTION.getDescription());
        this.errMessage = ExceptionEnum.COMMON_EXCEPTION.getDescription();
        this.errCode = RequestCodeConstant.FAIL;
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

    public static void throwError(String errMessage){
        throw new CommonBizException(errMessage);
    }

    public static void throwError(ExceptionEnum exceptionEnum){
        throw new CommonBizException(exceptionEnum.getCode(), exceptionEnum.getDescription());
    }
}
