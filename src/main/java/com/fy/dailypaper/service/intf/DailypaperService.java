package com.fy.dailypaper.service.intf;

import com.fy.dailypaper.entity.Dailypaper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fy.dailypaper.entity.User;
import com.fy.dailypaper.vo.R;
import io.swagger.models.auth.In;

import java.util.List;

/**
* @author flying
* @description 针对表【dailypaper(日报表)】的数据库操作Service
* @createDate 2022-05-28 20:16:01
*/
public interface DailypaperService  {

    //新增
    R<Integer> save(Dailypaper dailypaper);

    //查询全部
    List<Dailypaper> queryAll();
}
