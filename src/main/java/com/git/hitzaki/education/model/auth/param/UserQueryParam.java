package com.git.hitzaki.education.model.auth.param;

import com.git.hitzaki.education.common.model.PageParams;
import lombok.Data;

/**
 * 用户查询param
 * @author hitzaki
 */
@Data
public class UserQueryParam extends PageParams {
    private String phone;
    private String nickName;

    private Long salesmanId;
}
