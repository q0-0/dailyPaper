package com.fy.dailypaper.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fy.dailypaper.entity.Dailypaper;
import com.fy.dailypaper.service.intf.DailypaperService;
import com.fy.dailypaper.mapper.DailypaperMapper;
import com.fy.dailypaper.vo.R;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
* @author flying
* @description 针对表【dailypaper(日报表)】的数据库操作Service实现
* @createDate 2022-05-28 20:16:01
*/
@Service
public class DailypaperServiceImpl implements DailypaperService{

    @Resource
    private DailypaperMapper mapper;

    //新增
    @Override
    public R<Integer> save(Dailypaper dailypaper) {
        if (dailypaper != null){
         return R.ok(0,"OK" ,mapper.insert(dailypaper));
        }
        return R.fail();
    }

    //查询全部
    @Override
    public List<Dailypaper> queryAll() {
        List<Dailypaper> list = mapper.selectAll();
        return list;
    }
}




