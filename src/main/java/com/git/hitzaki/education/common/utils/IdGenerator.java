package com.git.hitzaki.education.common.utils;

/**
 * id生成工具
 * @author hitzaki
 */
public class IdGenerator {
    public static SnowflakeIdUtil snowflakeIdUtil = SnowflakeIdUtil.getInstance();

    public static Long generateId(){
        return snowflakeIdUtil.nextId();
    }

}
