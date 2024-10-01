package com.qzb.msg.service.dingding;

/**
 * 钉钉部门.
 *
 * @author <a href="mailto:qianzb@yxt.com">qianzb</a>
 * @date 2024-10-01 15:31
 * @since 1.0
 */
public interface IDingDingDeptService {

    /**
     * 同步机构部门.
     *
     * @param orgId orgId
     * @return  return
     */
    int syncDept(String orgId);

}
