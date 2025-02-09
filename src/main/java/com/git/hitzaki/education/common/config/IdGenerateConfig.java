package com.git.hitzaki.education.common.config;

import com.git.hitzaki.education.common.utils.SnowflakeIdUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * id相关配置
 * @author hitzaki
 */
@Configuration
public class IdGenerateConfig {

    /**
     * 雪花算法生成Id
     */
    @Bean
    public SnowflakeIdUtil snowflakeIdUtil(){
        return SnowflakeIdUtil.getInstance();
    }
}
