package com.fy.dailypaper.service.impl;

import com.fy.dailypaper.DailyPaperApplicationTests;
import com.fy.dailypaper.entity.Dailypaper;
import com.fy.dailypaper.mapper.DailypaperMapper;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DailypaperServiceImplTest extends DailyPaperApplicationTests {

    @Resource
    DailypaperMapper mapper;
    @Test
    void queryAll() {
        List<Dailypaper> dailypapers = mapper.selectAll();
        System.out.println(dailypapers);
    }
}