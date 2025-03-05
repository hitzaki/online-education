package com.git.hitzaki.education.common.utils;

import cn.dev33.satoken.stp.StpUtil;
import com.git.hitzaki.education.common.enums.ExceptionEnum;
import com.git.hitzaki.education.common.exception.CommonBizException;

import java.util.Objects;

/**
 * 用户登录信息工具
 * @author hitzaki
 */
public class AuthInfoUtils {
    private static final Character SEPARATE = '-';

    /**
     * 获取登录type
     */
    public static String getLoginType(){
        String loginInfo = (String)StpUtil.getLoginId();
        if (Objects.isNull(loginInfo)){
            CommonBizException.throwError(ExceptionEnum.COMMON_EXCEPTION);
        }
        return loginInfo.substring(0, loginInfo.indexOf(SEPARATE));
    }

    /**
     * 获取登录id
     */
    public static Long getLoginId(){
        String loginInfo = (String)StpUtil.getLoginId();
        if (Objects.isNull(loginInfo)){
            CommonBizException.throwError(ExceptionEnum.COMMON_EXCEPTION);
        }
        return Long.parseLong(loginInfo.substring(loginInfo.indexOf(SEPARATE) + 1));
    }

    /**
     * 构建登录信息
     */
    public static String buildLoginInfo(String loginType, Long loginId){
        return loginType + SEPARATE + loginId;
    }

    /**
     * 是否登录
     */
    //TODO
    public static boolean isLogin(){
        return true;
    }
}
