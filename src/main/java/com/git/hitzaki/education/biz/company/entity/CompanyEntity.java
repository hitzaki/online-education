package com.git.hitzaki.education.biz.company.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author author
 * @since 2025-01-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("company")
public class CompanyEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 公司名称
     */
    private String name;

    /**
     * 公司logo
     */
    private String logo;

    /**
     * 最小规模
     */
    private Integer minScale;

    /**
     * 最大规模
     */
    private Integer maxScale;

    /**
     * 公司类型
     */
    private Long subjectId;

    /**
     * 公司上市阶段
     */
    private Integer stage;


}
