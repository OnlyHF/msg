package com.qzb.msg.bootstrap.controller;

import com.qzb.msg.common.date.DateHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * StatusController.
 *
 * @Author qzb0212@126.com
 * @Date 2024-09-21 21:20:37
 */
@RestController
@RequestMapping("")
public class StatusController {

    @RequestMapping("/status")
    public Object status() {
        Map<String, String> map = new HashMap<>();
        map.put("status", "up");
        map.put("time", DateHelper.date2StrYMDHMS(new Date()));
        return map;
    }

}
