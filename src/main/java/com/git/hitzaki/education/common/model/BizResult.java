package com.git.hitzaki.education.common.model;

import com.git.hitzaki.education.common.constant.RequestCodeConstant;
import lombok.Data;
import lombok.ToString;

/**
 * 通用响应
 * @author hitzaki
 */
 @Data
 @ToString
public class BizResult<T> {

  /**
   * 响应编码,0为正常,-1错误
   */
  private int code;

  /**
   * 响应提示信息
   */
  private String msg;

  /**
   * 响应内容
   */
  private T data;


  public BizResult() {
   this(RequestCodeConstant.SUCCESS, "操作成功");
  }

  public BizResult(int code, String msg) {
   this.code = code;
   this.msg = msg;
  }

  /**
   * 错误信息的封装
   *
   * @param msg
   * @param <T>
   * @return
   */
  public static <T> BizResult<T> fail(String msg) {
   BizResult<T> response = new BizResult<T>();
   response.setCode(RequestCodeConstant.FAIL);
   response.setMsg(msg);
   return response;
  }
  public static <T> BizResult<T> fail(T result, String msg) {
   BizResult<T> response = new BizResult<T>();
   response.setCode(RequestCodeConstant.FAIL);
   response.setData(result);
   response.setMsg(msg);
   return response;
  }

    public static <T> BizResult<T> fail(Integer code, String msg) {
        BizResult<T> response = new BizResult<T>();
        response.setCode(code);
        response.setMsg(msg);
        return response;
    }

  /**
   * 添加正常响应数据（包含响应内容）
   *
   * @return RestResponse Rest服务封装相应数据
   */
  public static <T> BizResult<T> success(T result) {
   BizResult<T> response = new BizResult<T>();
   response.setData(result);
   return response;
  }
  public static <T> BizResult<T> success(T result, String msg) {
   BizResult<T> response = new BizResult<T>();
   response.setData(result);
   response.setMsg(msg);
   return response;
  }

  public static BizResult successByMsg(String msg){
      BizResult result = new BizResult();
      result.setMsg(msg);
      return result;
  }

  /**
   * 添加正常响应数据（不包含响应内容）
   *
   * @return RestResponse Rest服务封装相应数据
   */
  public static <T> BizResult<T> success() {
   return new BizResult<T>();
  }

 }