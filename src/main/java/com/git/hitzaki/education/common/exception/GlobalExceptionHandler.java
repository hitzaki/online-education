package com.git.hitzaki.education.common.exception;

import com.git.hitzaki.education.common.model.BizResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

/**
 * 全局异常处理器
 * @author hitzaki
 */
@Slf4j
 @ControllerAdvice//控制器增强
public class GlobalExceptionHandler {

  // 业务中台主动抛出的，可预知异常
  @ResponseBody//将信息返回为 json格式
  @ExceptionHandler(CommonBizException.class)
  public BizResult<Void> doBizException(CommonBizException e){
   log.error("捕获异常：{}",e.getErrMessage());

   return BizResult.fail(e.getErrCode(), e.getMessage());
  }


  //捕获不可预知异常 Exception
  @ResponseBody//将信息返回为 json格式
  @ExceptionHandler(Exception.class)//此方法捕获Exception异常
  public BizResult<Void> doException(Exception e){
   log.error("未知异常：{}",e.getMessage());
   return BizResult.fail(e.getMessage());
  }

  @ResponseBody//将信息返回为 json格式
  @ExceptionHandler(MethodArgumentNotValidException.class)//此方法捕获MethodArgumentNotValidException异常
  public RestErrorResponse doMethodArgumentNotValidException(MethodArgumentNotValidException e){
      BindingResult bindingResult = e.getBindingResult();
      //校验的错误信息
      List<FieldError> fieldErrors = bindingResult.getFieldErrors();
      //收集错误
      StringBuffer errors = new StringBuffer();
      fieldErrors.forEach(error->{
          errors.append(error.getDefaultMessage()).append(",");
      });
      return new RestErrorResponse(errors.toString());
  }

}
