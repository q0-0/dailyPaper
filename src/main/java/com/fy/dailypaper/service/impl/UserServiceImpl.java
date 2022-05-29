package com.fy.dailypaper.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fy.dailypaper.entity.User;
import com.fy.dailypaper.service.intf.UserService;
import com.fy.dailypaper.mapper.UserMapper;
import com.fy.dailypaper.utils.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author flying
* @description 针对表【user(用户表)】的数据库操作Service实现
* @createDate 2022-05-28 16:18:35
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{
    @Resource
    private  UserMapper mapper;

    //根据名字查询 登陆
    @Override
    public User queryByName(String name) {
        if (StringUtils.isNoyEmpty(name)){
          return  mapper.selectByName(name);
        }
        return null;
    }



    //注册
    public int userAdd(User user){
       if (user!= null){
         return mapper.insert(user);
       }
        return 0;
    }


}




