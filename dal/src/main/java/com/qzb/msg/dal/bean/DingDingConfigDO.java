package com.qzb.msg.dal.bean;

import lombok.Data;

import java.util.Date;

/**
 * DingDingConfigDO.
 *
 * @Author qzb0212@126.com
 * @Date 2024-09-23 21:08:52
 */
@Data
public class DingDingConfigDO {

    /**
     * 主键ID.
     */
    private Long id;

    /**
     * 机构ID.
     */
    private String orgId;

    /**
     * appId.
     */
    private String appId;

    /**
     * appKey.
     */
    private String appKey;

    /**
     * appSecret.
     */
    private String appSecret;

    /**
     * 启用状态：0-未启用，1-已启用.
     */
    private Integer configStatus;

    /**
     * 删除标识：0-未删除，1-已删除.
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
