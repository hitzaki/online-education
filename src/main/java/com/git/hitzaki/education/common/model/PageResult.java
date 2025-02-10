package com.git.hitzaki.education.common.model;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.git.hitzaki.education.common.constant.RequestCodeConstant;
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

  private int code = RequestCodeConstant.SUCCESS;

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

    public static <T> PageResult<T> convert(IPage<T> page) {
        return new PageResult<>(page.getRecords(),page.getTotal(), page.getCurrent(), page.getSize());
    }

 }
