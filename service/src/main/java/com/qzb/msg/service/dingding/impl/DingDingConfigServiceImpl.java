package com.qzb.msg.service.dingding.impl;

import com.qzb.msg.dal.bean.DingDingConfigDO;
import com.qzb.msg.dal.mapper.DingDingConfigMapper;
import com.qzb.msg.service.dingding.IDingDingConfigService;
import com.qzb.msg.service.util.AssertHelper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * DingDingConfigServiceImpl.
 *
 * @Author qzb0212@126.com
 * @Date 2024-10-01 15:37:20
 */
@Service
public class DingDingConfigServiceImpl implements IDingDingConfigService {

    @Resource
    private DingDingConfigMapper dingDingConfigMapper;

    @Override
    public DingDingConfigDO queryConfigByOrgIdAndAppId(final String orgId, final String appId) {
        AssertHelper.notNull(orgId, "orgId is not null");
        AssertHelper.notNull(appId, "appId is not null");
        return dingDingConfigMapper.queryByOrgIdAndAppId(orgId, appId);
    }

    @Override
    public List<DingDingConfigDO> queryByOrgId(final String orgId) {
        AssertHelper.notNull(orgId, "orgId is not null");
        return dingDingConfigMapper.queryByOrgId(orgId);
    }
}
