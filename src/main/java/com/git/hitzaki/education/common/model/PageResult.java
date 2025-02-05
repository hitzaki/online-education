package com.git.hitzaki.education.common.model;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * 分页响应
 * @author hitzaki
 */
 @Data
 @ToString
public class PageResult<T> {
  // 数据列表
  private List<T> items;

  //总记录数
  private long counts;

  private int code = 20000;

  //当前页码
  private long page;

  //每页记录数
  private long pageSize;

  public PageResult(List<T> items, long counts, long page, long pageSize) {
   this.items = items;
   this.counts = counts;
   this.page = page;
   this.pageSize = pageSize;
  }

  public PageResult(){

  }

 }
