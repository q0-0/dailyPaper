package com.fy.dailypaper.controller;

import com.fy.dailypaper.entity.Dailypaper;
import com.fy.dailypaper.entity.User;
import com.fy.dailypaper.service.intf.DailypaperService;
import com.fy.dailypaper.service.intf.UserService;
import com.fy.dailypaper.vo.R;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.lang.model.type.ArrayType;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("dailypaper")
@CrossOrigin
@RestController
@Api(value = "日报相关接口测试" , tags = "日报相关接口测试")
public class DailypaperController {
    @Resource
    private DailypaperService service;

    //新增
    @RequestMapping("add")
    public R<Integer> add(@RequestBody  Dailypaper dailypaper) {
     return  service.save(dailypaper);
    }

    //查询
    @RequestMapping("queryAll")
    public R<List<Dailypaper>> queryAll(){
        List<Dailypaper> dailypapers = service.queryAll();
        return R.ok(0,"OK",dailypapers);
    }


}
