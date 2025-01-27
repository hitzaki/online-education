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
 * 观看记录表
 * </p>
 *
 * @author author
 * @since 2025-01-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("video_schedule")
public class VideoSchedule implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 视频id
     */
    private Long videoId;

    /**
     * 看到了哪一帧，回退不算，仅记录最靠后的那一帧
     */
    private String time;

    private LocalDateTime updateTime;

    private LocalDateTime createTime;

    private Integer deleteFlag;


}
