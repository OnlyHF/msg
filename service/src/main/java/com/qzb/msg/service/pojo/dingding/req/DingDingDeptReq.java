package com.qzb.msg.service.pojo.dingding.req;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * DingDingDeptReq.
 *
 * @Author qzb0212@126.com
 * @Date 2024-10-01 19:24:44
 */
@Data
public class DingDingDeptReq {

    /**
     * 父部门ID.
     */
    @JSONField(name = "dept_id")
    private Long deptId;

    /**
     * 通讯录语言.
     * zh_CN (默认)：中文.
     * en_US: 英文.
     */
    private String language;

}
