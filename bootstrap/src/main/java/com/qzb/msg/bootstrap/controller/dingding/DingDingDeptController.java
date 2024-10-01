package com.qzb.msg.bootstrap.controller.dingding;

import com.qzb.msg.service.dingding.IDingDingDeptService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * DingDingDeptController.
 *
 * @Author qzb0212@126.com
 * @Date 2024-10-01 21:04:18
 */
@RestController
@RequestMapping("/dingding/dept")
public class DingDingDeptController {

    @Resource
    private IDingDingDeptService iDingDingDeptService;

    /**
     * 同步部门列表.
     *
     * @param orgId orgId
     * @return  return
     */
    @GetMapping("/sync/{orgId}")
    public Object syncDept(@PathVariable(name = "orgId") final String orgId) {
        int total = iDingDingDeptService.syncDept(orgId);
        return "ok: " + total;
    }

}
