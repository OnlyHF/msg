package com.qzb.msg.service.dingding;

import com.qzb.msg.dal.bean.DingDingConfigDO;

import java.util.List;

/**
 * IDingDingConfigService.
 *
 * @Author qzb0212@126.com
 * @Date 2024-10-01 15:34:31
 */
public interface IDingDingConfigService {

    /**
     * 查看钉钉配置.
     *
     * @param orgId
     * @param appId
     * @return
     */
    DingDingConfigDO queryConfigByOrgIdAndAppId(String orgId, String appId);

    /**
     * orgId查询钉钉配置.
     *
     * @param orgId
     * @return
     */
    List<DingDingConfigDO> queryByOrgId(String orgId);

}
