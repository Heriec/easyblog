package com.heriec.easyblogmaster.service;

import com.heriec.easyblogmaster.pojo.Pv;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PvService {

    int updateArticlePageView(Long aid);

    Long queryUserDayPv(Long uid, @Param("date1") String date1, @Param("date2") String date2);

    int pvStatisticsPerDay();

    List<String> getUserCategoryCount();

    List<Integer> getDataStatistics();


    int addPvForUserPerDay();
}
