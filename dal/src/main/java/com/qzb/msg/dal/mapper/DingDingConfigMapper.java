package com.qzb.msg.dal.mapper;

import com.qzb.msg.dal.bean.DingDingConfigDO;
import org.apache.ibatis.annotations.Param;

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
    DingDingConfigDO queryByAppId(@Param("orgId") String orgId, @Param("appId") String appId);

}
