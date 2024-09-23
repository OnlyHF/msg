package com.qzb.msg.service.pojo.common;

import lombok.Data;

/**
 * OkResult.
 *
 * @Author qzb0212@126.com
 * @Date 2024-09-23 22:04:45
 */
@Data
public class OkResult {

    private int code;

    private String body;

    public OkResult() {

    }

    public OkResult(final int code, final String body) {
        this.code = code;
        this.body = body;
    }
}
