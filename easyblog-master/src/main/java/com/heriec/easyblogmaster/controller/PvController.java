package com.heriec.easyblogmaster.controller;

import com.heriec.easyblogmaster.service.PvService;
import com.heriec.easyblogmaster.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/pv")
public class PvController {

    @Autowired
    private PvService pvService;

    @RequestMapping("/dataStatistics")
    public Map<String,Object> dataStatistics() {
        Map<String, Object> map = new HashMap<>();
        List<String> categories = pvService.getUserCategoryCount();
        List<Integer> dataStatistics = pvService.getDataStatistics();
        map.put("categories", categories);
        map.put("ds", dataStatistics);
        return map;
    }

//    //每天执行一次，统计PV    1 0 0 * * ?
//    @Scheduled(cron = "0/10 * * * * ?")
//    public void pvStatisticsPerDay() {
//        System.out.println("执行了内");
//        pvService.addPvForUserPerDay();
//    }
}
