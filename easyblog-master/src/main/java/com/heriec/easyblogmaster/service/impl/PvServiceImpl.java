package com.heriec.easyblogmaster.service.impl;

import com.heriec.easyblogmaster.dao.PvDao;
import com.heriec.easyblogmaster.pojo.Pv;
import com.heriec.easyblogmaster.service.PvService;
import com.heriec.easyblogmaster.utils.UserUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Service
public class PvServiceImpl implements PvService {

    @Autowired
    private PvDao pvDao;

    @Override
    public int updateArticlePageView(Long aid) {
        return pvDao.updateArticlePageView(aid);
    }

    @Override
    public Long queryUserDayPv(Long uid, String date1, String date2) {
        return pvDao.queryUserDayPv(uid,date1,date2);
    }


    @Override
    public int pvStatisticsPerDay() {
        return 0;
    }

    @Override
    public List<String> getUserCategoryCount() {
        return pvDao.getUserDayArticleCount(UserUtil.getCurrentUser().getId());
    }

    @Override
    public List<Integer> getDataStatistics() {
        return pvDao.getDataStatistics(UserUtil.getCurrentUser().getId());
    }

    @Override
    public int addPvForUserPerDay() {
        Pv pv = new Pv();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(new Date());
        calendar.add(calendar.DATE,-1);
        String date1= sdf.format(calendar.getTime());
        pv.setCountDate(date1);
        pv.setUid(7L);
        Integer a = Integer.parseInt(date1.substring(9, 10));//天
        String aa = "" + (a + 1);
        StringBuilder day = new StringBuilder(date1);
        day.replace(9, 10, aa);
        String date2 = day.toString();
        System.out.println(date1);
        System.out.println(date2);
        pv.setPv(pvDao.queryUserDayPv(7L,date1,date2));

        return pvDao.addPvForUserPerDay(pv);
    }
}
