package com.qzb.msg.dal.mapper;

import com.qzb.msg.dal.bean.DingDingUserDO;
import org.apache.ibatis.annotations.Param;

/**
 * msg.
 *
 * @author <a href="mailto:qianzb@yxt.com">qianzb</a>
 * @date 2024-09-22 20:24
 * @since 1.0
 */
public interface DingDingUserMapper {

    /**
     * 根据id查询.
     *
     * @param id    id
     * @return  return
     */
    DingDingUserDO queryById(@Param("id") Long id);

}
