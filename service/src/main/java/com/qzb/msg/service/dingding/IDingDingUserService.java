package com.qzb.msg.service.dingding;

import com.qzb.msg.dal.bean.DingDingUserDO;

/**
 * msg.
 *
 * @author <a href="mailto:qianzb@yxt.com">qianzb</a>
 * @date 2024-09-22 11:04
 * @since 1.0
 */
public interface IDingDingUserService {

    /**
     * 根据ID查询.
     *
     * @param id    id
     * @return  DingDingUserDO
     */
    DingDingUserDO queryById(long id);

}
