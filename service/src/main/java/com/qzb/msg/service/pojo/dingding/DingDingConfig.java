package com.qzb.msg.service.pojo.dingding;

import lombok.Builder;
import lombok.Data;

/**
 * DingDingConfig.
 *
 * @Author qzb0212@126.com
 * @Date 2024-09-23 22:12:07
 */
@Data
@Builder
public class DingDingConfig {

    /**
     * appKey.
     */
    private String appKey;

    /**
     * appSecret.
     */
    private String appSecret;

}
