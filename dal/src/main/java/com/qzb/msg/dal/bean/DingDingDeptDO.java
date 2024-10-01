package com.qzb.msg.dal.bean;

import lombok.Data;

import java.util.Date;

/**
 * msg_dingding_dept.
 *
 * @Author qzb0212@126.com
 * @Date 2024-10-01 14:54:06
 */
@Data
public class DingDingDeptDO {

    /**
     * 主键ID.
     */
    private Long id;

    /**
     * orgId.
     */
    private String orgId;

    /**
     * appId.
     */
    private String appId;

    /**
     * 部门ID.
     */
    private Long deptId;

    /**
     * 部门名称.
     */
    private String deptName;

    /**
     * 父部门ID.
     */
    private Long parentId;

    /**
     * 是否同步创建一个关联此部门的企业群：0-不创建，1-创建.
     */
    private Integer createDeptGroup;

    /**
     * 部门群已经创建后，又新人加入部门是否会自动加入该群：0-不会，1-回自动入群.
     */
    private Integer autoAddUser;

    /**
     * 删除标识.
     */
    private Integer deleted;

    /**
     * 创建时间.
     */
    private Date createTime;

    /**
     * 更新时间.
     */
    private Date updateTime;

}
