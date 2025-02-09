package com.git.hitzaki.education.common.exception;

/**
 * 中台通用异常
 * @author hitzaki
 */
public class CommonBizException extends RuntimeException {

    private String errMessage;

    private Integer errCode;

    public CommonBizException() {
        super();
    }

    public CommonBizException(String message) {
        super(message);
        this.errMessage = message;
    }

    public String getErrMessage(){
        return errMessage;
    }

    public static void cast(String errMessage){
        throw new CommonBizException(errMessage);
    }
    public static void cast(CommonError commonError){
        throw new CommonBizException(commonError.getErrMessage());
    }
}
