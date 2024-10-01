package com.qzb.msg.service.dingding.api;

import com.alibaba.fastjson.JSONObject;
import com.qzb.msg.dal.bean.DingDingConfigDO;
import com.qzb.msg.service.common.OkService;
import com.qzb.msg.service.dingding.IDingDingConfigService;
import com.qzb.msg.service.pojo.common.OkResult;
import com.qzb.msg.service.pojo.dingding.DingDingToken;
import com.qzb.msg.service.pojo.dingding.DingDingConfig;
import com.qzb.msg.service.pojo.dingding.req.DingDingDeptReq;
import com.qzb.msg.service.pojo.dingding.res.DeptBaseRes;
import com.qzb.msg.service.pojo.dingding.res.DingDingCommonRes;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

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

    public static final String OPEN_API_DOMAIN = "https://oapi.dingtalk.com";

    @Resource
    private OkService okService;

    @Resource
    private IDingDingConfigService iDingDingConfigService;

    /**
     * getToken.
     *
     * @param orgId orgId
     * @param appId appId
     * @return  return
     */
    public String getToken(final String orgId, final String appId) {
        DingDingConfigDO configDO = iDingDingConfigService.queryConfigByOrgIdAndAppId(orgId, appId);
        if (ObjectUtils.isEmpty(configDO)) {
            return "";
        }
        return getTokenApi(configDO.getAppKey(), configDO.getAppSecret());
    }

    /**
     * getTokenApi.
     *
     * @param appKey    appKey
     * @param appSecret appSecret
     * @return  return
     */
    public String getTokenApi(final String appKey, final String appSecret) {
        DingDingConfig dingDingConfig = DingDingConfig.builder().appKey(appKey).appSecret(appSecret).build();
        String url = DOMAIN + "/v1.0/oauth2/accessToken";
        OkResult okResult = okService.post(url, dingDingConfig);
        if (checkResult(okResult)) {
            DingDingToken dingDIngToken = JSONObject.parseObject(okResult.getBody(), DingDingToken.class);
            return dingDIngToken.getAccessToken();
        }
        return "";
    }

    /**
     * 获取部门列表.
     * https://open.dingtalk.com/document/orgapp/obtain-the-department-list-v2.
     *
     * @param appKey        appKey
     * @param appSecret     appSecret
     * @param deptReq       deptReq
     * @return              return
     */
    public List<DeptBaseRes> deptListSub(final String appKey, final String appSecret, final DingDingDeptReq deptReq) {
        String url = OPEN_API_DOMAIN + "/topapi/v2/department/listsub?access_token=%s";
        String token = getTokenApi(appKey, appSecret);
        url = String.format(url, token);
        OkResult okResult = okService.post(url, deptReq);
        if (checkResult(okResult)) {
            DingDingCommonRes res = JSONObject.parseObject(okResult.getBody(), DingDingCommonRes.class);
            if (res.getErrCode() == 0) {
                List<DeptBaseRes> deptList = JSONObject.parseArray(JSONObject.toJSONString(res.getResult()), DeptBaseRes.class);
                return deptList;
            }
        }
        log.info("部门列表接口获取失败url={}", url);
        return null;
    }

    /**
     * checkResult.
     *
     * @param okResult  okResult
     * @return  true-success;false-fail
     */
    public boolean checkResult(final OkResult okResult) {
        return okResult.getCode() >= 200 && okResult.getCode() <= 300;
    }

}
