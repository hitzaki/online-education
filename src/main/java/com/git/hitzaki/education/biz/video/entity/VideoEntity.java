package com.git.hitzaki.education.biz.video.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 课程视频
 * </p>
 *
 * @author author
 * @since 2025-01-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("video")
public class VideoEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 课程ID
     */
    private Long courseId;

    /**
     * 章节ID
     */
    private Long chapterId;

    /**
     * 节点名称
     */
    private String title;

    /**
     * 视频URL
     */
    private String videoUrl;

    /**
     * 原始文件名称
     */
    private String videoOriginalName;

    /**
     * 云端视频资源
     */
    private String videoSourceId;

    /**
     * 播放次数
     */
    private Long playCount;

    /**
     * 视频源文件大小（字节）
     */
    private Long size;

    /**
     * 视频时长（秒）
     */
    private Float duration;

    /**
     * 状态
     */
    private Integer status;

    private Integer deleteFlag;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;


}
