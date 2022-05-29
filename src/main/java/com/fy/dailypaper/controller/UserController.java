package com.fy.dailypaper.controller;

import com.fy.dailypaper.entity.User;
import com.fy.dailypaper.service.intf.UserService;
import com.fy.dailypaper.utils.MailUtils;
import com.fy.dailypaper.utils.StringUtils;
import com.fy.dailypaper.vo.R;
import io.swagger.annotations.Api;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@RequestMapping("user")
@CrossOrigin
@RestController
@Api(value = "用户相关接口测试" , tags = "用户相关接口测试")
public class UserController {
    @Resource
    private UserService service;
    @Resource
    private StringRedisTemplate template;

    //登陆
//    @RequestMapping("login")
//    public R<User> login(String name, String password, String code,HttpSession session) {
//        if (Objects.equals(code,session.getAttribute("code"))){
//            User user = service.queryByName(name);
//            if (password.equals(user.getPassword())) {
//                return R.ok(0, "登陆成功", user);
//            }
//            return R.fail(-1, "账户名或密码错误", null);
//        }
//        return R.fail(-1, "验证码错误", null);
//    }


     /**
     * redisTemplate.opsForValue().getOperations().getExpire("key的名称")
     * 从redis中获取key对应的过期时间;
     * 如果该值有过期时间，就返回相应的过期时间;
     * 如果该值没有设置过期时间，就返回-1;
     * 如果没有该值，就返回-2;
     */
    @RequestMapping("login")
    public R<User> login(String name, String password, String email,String code) {

        if (template.opsForValue().getOperations().getExpire("user:" + email) == -2){
            return  R.fail(-1, "验证码已过期", null);
        }else {
            if (Objects.equals(code, template.opsForValue().get("user:" + email))){
                User user = service.queryByName(name);
                if (password.equals(user.getPassword())){
                    return R.ok(0, "登陆成功", user);
                }else {
                    return R.fail(-1, "账户名或密码错误", null);
                }
            }else {
                return  R.fail(-1, "验证码错误", null);
            }
        }
    }




    @RequestMapping("add")
    public R<Integer> registered(@RequestBody User user) {
        //先查询用户名是否存在
      if (service.queryByName(user.getName())!= null){
            return R.fail(-1, "用户名已存在", null);
        }else {
            service.userAdd(user);
          return   R.ok(0,"新用户注册成功", null);

        }
    }


    //发送邮箱验证码
//    @RequestMapping("sendEmail")
//    public R<String> sendEmail(String email, HttpSession session){
//        System.out.println(email);
//        //1 生成一个验证码 （可以是一个随机数）
//        String code = RandomStringUtils.randomNumeric(4);
//        //2 jsp前端 可以把验证码放入session中 登陆进来时可以比对验证码
//        session.setAttribute("code",code);
//        //3 发送邮件
//        if (StringUtils.isNoyEmpty(email)){
//            MailUtils.sendMail(email,"来自日报APP的验证码", "您的验证码是："+ code);
//            return R.ok(0,"验证码发送成功",code);
//        }
//
//        return R.fail(-1,"请输入正确的邮箱号码",null);
//    }

    @RequestMapping("sendEmail")
    public R<String> sendEmail(String email){
        //1 生成一个验证码 （可以是一个随机数）
        String code = RandomStringUtils.randomNumeric(4);
        //2 把验证码放入redis中 并设置有效期 登陆进来时可以比对验证码
            //设置缓存时间 TimeUnit.SECONDS 单位:秒
        template.opsForValue().set("user:" + email, code,30, TimeUnit.SECONDS );
        //3 发送邮件
        if (StringUtils.isNoyEmpty(email)){
            MailUtils.sendMail(email,"来自日报APP的验证码", "您的验证码是："+ code);
            return R.ok(0,"验证码发送成功",code);
        }

        return R.fail(-1,"请输入正确的邮箱号码",null);
    }

}
