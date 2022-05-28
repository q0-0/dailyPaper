package com.fy.dailypaper.mapper;

import com.fy.dailypaper.DailyPaperApplicationTests;
import com.fy.dailypaper.entity.User;
import org.junit.jupiter.api.Test;


import javax.annotation.Resource;



class UserMapperTest extends DailyPaperApplicationTests {

    @Resource
    UserMapper mapper;


    @Test
    void  selectByName(){
        System.out.println(mapper.selectByName("xx"));
    }
}