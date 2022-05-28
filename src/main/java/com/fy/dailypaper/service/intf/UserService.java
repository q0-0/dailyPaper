package com.fy.dailypaper.service.intf;

import com.fy.dailypaper.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author flying
* @description 针对表【user(用户表)】的数据库操作Service
* @createDate 2022-05-28 16:18:35
*/
public interface UserService extends IService<User> {

    //  注册
    int userAdd(User user);

    //  根据姓名查询
    User queryByName(String name);
}
