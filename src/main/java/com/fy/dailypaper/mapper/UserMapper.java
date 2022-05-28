package com.fy.dailypaper.mapper;

import com.fy.dailypaper.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author flying
* @description 针对表【user(用户表)】的数据库操作Mapper
* @createDate 2022-05-28 16:18:35
* @Entity com.fy.dailypaper.entity.User
*/
public interface UserMapper extends BaseMapper<User> {


    //根据姓名查询 登陆
    User selectByName(String name);







}




