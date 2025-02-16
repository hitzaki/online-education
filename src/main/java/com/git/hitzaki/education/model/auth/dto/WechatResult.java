package com.git.hitzaki.education.model.auth.dto;

import lombok.Data;

@Data
public class WechatResult {
    private Long id;
    private String openid;
    private String unionid;
    private String nickname;
    private String avatarUrl;
    private String sessionKey;
}
