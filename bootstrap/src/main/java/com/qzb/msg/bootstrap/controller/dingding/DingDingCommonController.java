package com.qzb.msg.bootstrap.controller.dingding;

import com.qzb.msg.service.dingding.api.DingDingCommonService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * DingDingCommonController.
 *
 * @Author qzb0212@126.com
 * @Date 2024-09-23 22:15:13
 */
@RestController
@RequestMapping("/dingding/common")
public class DingDingCommonController {

    @Resource
    private DingDingCommonService dingDingCommonService;

    /**
     * getToken.
     *
     * @return  return
     */
    @GetMapping("/gettoken")
    public Object getToken() {
        String token = dingDingCommonService.getToken("123", "323fd279-c50e-4c7a-9a7a-a560c43de393");
        return token;
    }

}
