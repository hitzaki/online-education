package com.git.hitzaki.education.model.course.vo;


import lombok.Data;

@Data
public class ProgressQueryVo {
    private Long id;
    private String name;
    private Integer now = 0;
    private Integer all = 0;

    public void add(ProgressQueryVo other){
        this.all = this.all+other.all;
        this.now = this.now+other.now;
    }
}
