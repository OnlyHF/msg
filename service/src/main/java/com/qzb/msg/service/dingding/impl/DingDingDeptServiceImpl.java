package com.qzb.msg.service.dingding.impl;

import com.qzb.msg.dal.bean.DingDingConfigDO;
import com.qzb.msg.dal.bean.DingDingDeptDO;
import com.qzb.msg.dal.mapper.DingDingDeptMapper;
import com.qzb.msg.service.dingding.IDingDingConfigService;
import com.qzb.msg.service.dingding.IDingDingDeptService;
import com.qzb.msg.service.dingding.api.DingDingCommonService;
import com.qzb.msg.service.pojo.dingding.req.DingDingDeptReq;
import com.qzb.msg.service.pojo.dingding.res.DeptBaseRes;
import com.qzb.msg.service.util.IdWorker;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Date;
import java.util.List;

/**
 * DingDingDeptServiceImpl.
 *
 * @Author qzb0212@126.com
 * @Date 2024-10-01 15:32:39
 */
@Service
public class DingDingDeptServiceImpl implements IDingDingDeptService {

    @Resource
    private IDingDingConfigService iDingDingConfigService;

    @Resource
    private DingDingCommonService dingDingCommonService;

    @Resource
    private IdWorker idWorker;

    @Resource
    private DingDingDeptMapper dingDingDeptMapper;

    @Override
    public int syncDept(final String orgId) {
        List<DingDingConfigDO> dingConfigDOList = iDingDingConfigService.queryByOrgId(orgId);
        dingConfigDOList.forEach(configDO -> syncDeptByConfig(configDO));
        return dingConfigDOList.size();
    }

    /**
     * 部门列表同步.
     *
     * @param configDO  configDO
     */
    private void syncDeptByConfig(final DingDingConfigDO configDO) {
        DingDingDeptReq deptReq = new DingDingDeptReq();
        List<DeptBaseRes> deptListSub = dingDingCommonService.deptListSub(configDO.getAppKey(), configDO.getAppSecret(), deptReq);
        deptListSub.forEach(deptRes -> {
            DingDingDeptDO deptDO = dingDingDeptMapper.queryByDeptId(configDO.getOrgId(), configDO.getAppId(), deptRes.getDeptId());
            if (ObjectUtils.isEmpty(deptDO)) {
                deptDO = new DingDingDeptDO();
                BeanUtils.copyProperties(deptRes, deptDO);
                BeanUtils.copyProperties(configDO, deptDO);
                deptDO.setId(idWorker.nextId());
                deptDO.setDeptName(deptRes.getName());
                deptDO.setCreateDeptGroup(deptRes.getCreateDeptGroup() ? 1 : 0);
                deptDO.setAutoAddUser(deptRes.getAutoAddUser() ? 1 : 0);
                deptDO.setDeleted(0);
                deptDO.setCreateTime(new Date());
                deptDO.setUpdateTime(deptDO.getCreateTime());
                dingDingDeptMapper.insert(deptDO);
            } else {
                BeanUtils.copyProperties(deptRes, deptDO);
                deptDO.setDeptName(deptRes.getName());
                deptDO.setCreateDeptGroup(deptRes.getCreateDeptGroup() ? 1 : 0);
                deptDO.setAutoAddUser(deptRes.getAutoAddUser() ? 1 : 0);
                deptDO.setUpdateTime(new Date());
                dingDingDeptMapper.updateById(deptDO);
            }
        });
    }

}
