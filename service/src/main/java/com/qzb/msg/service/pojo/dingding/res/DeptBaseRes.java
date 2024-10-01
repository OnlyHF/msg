package com.qzb.msg.service.pojo.dingding.res;

import lombok.Data;

/**
 * DeptBaseRes.
 *
 * @Author qzb0212@126.com
 * @Date 2024-10-01 20:39:26
 */
@Data
public class DeptBaseRes {

    /**
     * 部门ID.
     */
    private Long deptId;

    /**
     * 部门名称.
     */
    private String name;

    /**
     * 父部门ID.
     */
    private Long parentId;

    /**
     * 是否同步创建一个关联此部门的企业群.
     * true：创建.
     * false：不创建.
     */
    private Boolean createDeptGroup;

    /**
     * 部门群已经创建后，有新人加入部门是否会自动加入该群.
     * true：会自动入群.
     * false：不会.
     */
    private Boolean autoAddUser;

}
