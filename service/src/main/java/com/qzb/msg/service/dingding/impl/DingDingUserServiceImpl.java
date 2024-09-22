package com.qzb.msg.service.dingding.impl;

import com.qzb.msg.dal.bean.DingDingUserDO;
import com.qzb.msg.dal.mapper.DingDingUserMapper;
import com.qzb.msg.service.dingding.IDingDingUserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * DbServiceImpl.
 *
 * @Author qzb0212@126.com
 * @Date 2024-09-22 11:05:20
 */
@Service
public class DingDingUserServiceImpl implements IDingDingUserService {

    @Resource
    private DingDingUserMapper dingDingUserMapper;

    /**
     * 根据ID查询.
     *
     * @param id    id
     * @return  return
     */
    @Override
    public DingDingUserDO queryById(final long id) {
        return dingDingUserMapper.queryById(id);
    }

}
