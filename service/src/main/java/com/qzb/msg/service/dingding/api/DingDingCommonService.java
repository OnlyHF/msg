package com.qzb.msg.service.dingding.api;

import com.alibaba.fastjson.JSONObject;
import com.qzb.msg.dal.bean.DingDingConfigDO;
import com.qzb.msg.dal.mapper.DingDingConfigMapper;
import com.qzb.msg.service.common.OkService;
import com.qzb.msg.service.pojo.common.OkResult;
import com.qzb.msg.service.pojo.dingding.DingDIngToken;
import com.qzb.msg.service.pojo.dingding.DingDingConfig;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * 钉钉公共方法.
 *
 * @Author qzb0212@126.com
 * @Date 2024-09-23 21:29:50
 */
@Service
@Slf4j
public class DingDingCommonService {

    public static final String DOMAIN = "https://api.dingtalk.com";

    @Resource
    private OkService okService;

    @Resource
    private DingDingConfigMapper dingDingConfigMapper;

    /**
     * getToken.
     *
     * @param orgId orgId
     * @param appId appId
     * @return  return
     */
    public String getToken(final String orgId, final String appId) {
        DingDingConfigDO configDO = dingDingConfigMapper.queryByAppId(orgId, appId);
        if (ObjectUtils.isEmpty(configDO)) {
            return "";
        }
        OkResult okResult = getTokenApi(configDO.getAppKey(), configDO.getAppSecret());
        DingDIngToken dingDIngToken = JSONObject.parseObject(okResult.getBody(), DingDIngToken.class);
        return dingDIngToken.getAccessToken();
    }

    /**
     * getTokenApi.
     *
     * @param appKey    appKey
     * @param appSecret appSecret
     * @return  return
     */
    public OkResult getTokenApi(final String appKey, final String appSecret) {
        DingDingConfig dingDingConfig = DingDingConfig.builder().appKey(appKey).appSecret(appSecret).build();
        String url = DOMAIN + "/v1.0/oauth2/accessToken";
        return okService.post(url, dingDingConfig);
    }

}
