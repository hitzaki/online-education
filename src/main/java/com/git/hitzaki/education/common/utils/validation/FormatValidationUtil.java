package com.git.hitzaki.education.common.utils.validation;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 格式校验工具
 * @author hitzaki
 */
public class FormatValidationUtil {
    /**
     * 校验用户手机号是否合法
     */
    public static Boolean isPhoneCode(String phone){
        String regex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(phone);
        return m.matches();
    }

    public static Boolean isId(Long id){
        return Objects.nonNull(id) && id > 0;
    }

}
