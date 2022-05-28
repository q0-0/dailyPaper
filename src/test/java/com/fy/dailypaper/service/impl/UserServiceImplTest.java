package com.fy.dailypaper.service.impl;

import com.fy.dailypaper.DailyPaperApplicationTests;
import com.fy.dailypaper.mapper.UserMapper;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest extends DailyPaperApplicationTests {

    @Resource
    UserMapper mapper;
    @Test
    void queryByName() {
        mapper.selectByName("xx");
    }

    @Test
    void userAdd() {
    }
}