package com.git.hitzaki.education.model.auth.param;

import com.git.hitzaki.education.common.model.PageParams;
import lombok.Data;

/**
 * 权限查询param
 * @author hitzaki
 */
@Data
public class PermissionQueryParam extends PageParams {

    private String name;

    private String code;

    private Long roleId;
}
