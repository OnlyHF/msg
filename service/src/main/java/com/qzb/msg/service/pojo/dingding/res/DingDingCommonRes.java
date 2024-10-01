package com.qzb.msg.service.pojo.dingding.res;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * DingDingCommonRes.
 *
 * @Author qzb0212@126.com
 * @Date 2024-10-01 20:37:12
 */
@Data
public class DingDingCommonRes<T> {

    /**
     * 请求ID.
     */
    @JSONField(name = "request_id")
    private String requestId;

    /**
     * 返回码(0-成功).
     */
    @JSONField(name = "errcode")
    private Long errCode;

    /**
     * 调用失败时返回的错误信息.
     */
    @JSONField(name = "errmsg")
    private String errMsg;

    /**
     * result.
     */
    private T result;

}
