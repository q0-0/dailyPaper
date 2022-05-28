package com.fy.dailypaper.mapper;

import com.fy.dailypaper.entity.Dailypaper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author flying
* @description 针对表【dailypaper(日报表)】的数据库操作Mapper
* @createDate 2022-05-28 20:16:01
* @Entity com.fy.dailypaper.entity.Dailypaper
*/
public interface DailypaperMapper extends BaseMapper<Dailypaper> {
    //新增
    int add(Dailypaper dailypaper);

    //查询全部
    List<Dailypaper> selectAll();
}




