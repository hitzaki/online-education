package com.git.hitzaki.education.common.model;

import com.git.hitzaki.education.common.model.constant.ExceptionEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
/**
 * 统一返回对象
 * */
public class Result {
    private Object data;
    private Integer code;
    private String msg;


    public boolean isSuccess(){
        return this.code == 200;
    }
    public static Result ok(Object date){
        return new Result(date,200,"");
    }

    public static Result ok(){
        return ok(new Object());
    }

    public static Result error(Integer code,String msg){
        return new Result(new Object(),code,msg);
    }

    public static Result error(ExceptionEnum exceptionEnum){
        return error(exceptionEnum.getCode(),exceptionEnum.getDescription());
    }

    public static Result error(String msg){
        return error(ExceptionEnum.COMMON_EXCEPTION.getCode(),msg);
    }

}
