package com.git.hitzaki.education.common.model;

import lombok.Data;
import lombok.ToString;

/**
 * 分页请求参数
 * @author hitzaki
 */
@Data
@ToString
public class PageParams {

  //当前页码默认值
  public static final long DEFAULT_PAGE_CURRENT = 1L;
  //每页记录数默认值
  public static final long DEFAULT_PAGE_SIZE = 10L;

  //当前页码
  private Long pageNo = DEFAULT_PAGE_CURRENT;

  //每页记录数默认值
  private Long pageSize = DEFAULT_PAGE_SIZE;

  public PageParams(){

  }

  public PageParams(long pageNo,long pageSize){
   this.pageNo = pageNo;
   this.pageSize = pageSize;
  }
}
