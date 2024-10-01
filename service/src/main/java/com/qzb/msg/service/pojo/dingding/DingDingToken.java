package com.qzb.msg.service.pojo.dingding;

import lombok.Data;

/**
 * DingDingToken.
 *
 * @Author qzb0212@126.com
 * @Date 2024-09-23 22:20:47
 */
@Data
public class DingDingToken {

    /**
     * token.
     */
    private String accessToken;

    /**
     * expireIn.
     */
    private Integer expireIn;

}
