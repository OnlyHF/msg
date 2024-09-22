package com.qzb.msg.bootstrap.controller.dingding;

import com.qzb.msg.bootstrap.model.vo.dingding.DingDingUserVO;
import com.qzb.msg.dal.bean.DingDingUserDO;
import com.qzb.msg.service.dingding.IDingDingUserService;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * DingDingUserController.
 *
 * @Author qzb0212@126.com
 * @Date 2024-09-22 20:44:41
 */
@RestController
@RequestMapping("/dingding/user")
public class DingDingUserController {

    @Resource
    private IDingDingUserService iDingDingUserService;

    /**
     * 根据ID查询.
     *
     * @param id    id
     * @return  return
     */
    @GetMapping("/{id}")
    public Object queryById(@PathVariable("id") final long id) {
        DingDingUserDO dingDingUserDO = iDingDingUserService.queryById(id);
        DingDingUserVO userVO = new DingDingUserVO();
        BeanUtils.copyProperties(dingDingUserDO, userVO);
        return userVO;
    }

}
