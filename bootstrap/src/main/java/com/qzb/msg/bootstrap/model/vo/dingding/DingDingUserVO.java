package com.qzb.msg.bootstrap.model.vo.dingding;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.util.Date;

/**
 * DingDingUserDO.
 *
 * @Author qzb0212@126.com
 * @Date 2024-09-22 20:22:48
 */
@Data
public class DingDingUserVO {

    /**
     * 主键ID.
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    /**
     * 机构ID.
     */
    private String orgId;

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
