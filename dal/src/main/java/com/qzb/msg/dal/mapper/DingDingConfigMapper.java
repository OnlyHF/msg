package com.qzb.msg.dal.mapper;

import com.qzb.msg.dal.bean.DingDingConfigDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * msg_dingding_config.
 *
 * @author <a href="mailto:qianzb@yxt.com">qianzb</a>
 * @date 2024-09-22 20:24
 * @since 1.0
 */
public interface DingDingConfigMapper {

    /**
     * 根据appId查询钉钉配置.
     *
     * @param orgId
     * @param appId
     * @return
     */
    DingDingConfigDO queryByOrgIdAndAppId(@Param("orgId") String orgId, @Param("appId") String appId);

    /**
     * 查询orgId配置的钉钉.
     *
     * @param orgId
     * @return
     */
    List<DingDingConfigDO> queryByOrgId(@Param("orgId") String orgId);

}
