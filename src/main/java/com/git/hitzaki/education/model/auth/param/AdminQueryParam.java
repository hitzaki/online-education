package com.git.hitzaki.education.model.auth.param;

import com.git.hitzaki.education.common.model.PageParams;
import lombok.Data;

/**
 * 管理员查询param
 * @author hitzaki
 */
@Data
public class AdminQueryParam extends PageParams {
    private String account;

    private String nickName;
}
