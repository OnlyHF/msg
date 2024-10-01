package com.qzb.msg.dal.mapper;

import com.qzb.msg.dal.bean.DingDingDeptDO;
import org.apache.ibatis.annotations.Param;

/**
 * msg_dingding_dept.
 *
 * @author <a href="mailto:qianzb@yxt.com">qianzb</a>
 * @date 2024-10-01 14:52
 * @since 1.0
 */
public interface DingDingDeptMapper {

    /**
     * 根据部门id查询.
     *
     * @param orgId
     * @param appId
     * @param deptId
     * @return
     */
    DingDingDeptDO queryByDeptId(@Param("orgId") String orgId,
                                 @Param("appId") String appId,
                                 @Param("deptId") Long deptId);

    /**
     * 新增数据.
     *
     * @param deptDO
     * @return
     */
    int insert(DingDingDeptDO deptDO);

    /**
     * 根据id更新数据.
     *
     * @param deptDO
     * @return
     */
    int updateById(DingDingDeptDO deptDO);

}
