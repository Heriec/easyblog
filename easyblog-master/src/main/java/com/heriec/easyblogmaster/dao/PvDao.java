package com.heriec.easyblogmaster.dao;

import com.heriec.easyblogmaster.pojo.Pv;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface PvDao {
    /**
     * 阅览量增加，这个后面可以用redis处理
     *
     * @param aid
     * @return
     */
    int updateArticlePageView(Long aid);

    Long queryUserDayPv(@Param("uid") Long uid,@Param("date1") String date1,@Param("date2") String date2);

    List<String> getUserDayArticleCount(Long uid);

    List<Integer> getDataStatistics(Long uid);

    /**
     * 每天更新一下pv的值
     *
     * @return
     */
    int addPvForUserPerDay(Pv pv);
}
