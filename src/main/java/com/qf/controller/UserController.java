package com.qf.controller;

import com.qf.common.OrderResp;
import com.qf.common.UserResp;
import com.qf.pojo.User;
import com.qf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import java.util.ArrayList;

@RestController
@RequestMapping("/user")
@SessionAttributes("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public UserResp insertregister(User user){
        int register = userService.insertregister(user);
        ArrayList arrayList = new ArrayList();
        UserResp userResp = new UserResp();
        if (register == 1){
            userResp.setCode(1);
            return userResp;
        }
        userResp.setCode(0);
        arrayList.add("注册失败");
        userResp.setInfo(arrayList);
        return userResp;
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public UserResp selectByTel(User user,ModelMap modelMap){
        User user1 = userService.selectByTel(user.getTel());
        UserResp userResp = new UserResp();
        ArrayList arrayList = new ArrayList();
        if (user1 != null){
            if (user1.getPassword().equals(user.getPassword())){
                modelMap.addAttribute("user",user1);
                userResp.setCode(1);
                return userResp;
            }else {
                userResp.setCode(0);
                arrayList.add("密码错误");
                userResp.setInfo(arrayList);
                return userResp;
            }
        }else {
            userResp.setCode(0);
            arrayList.add("用户不存在");
            userResp.setInfo(arrayList);
            return userResp;
        }
    }

    @RequestMapping(value = "/checkLogin",method = RequestMethod.POST)
    public UserResp checkLogin(ModelMap modelMap){
        User user =(User) modelMap.get("user");
        UserResp userResp = new UserResp();
        if (user != null){
            userResp.setCode(1);
            return userResp;
        }else {
            userResp.setCode(0);
            return userResp;
        }
    }

    @RequestMapping(value = "/loginOut",method = RequestMethod.POST)
    public UserResp loginOut(SessionStatus sessionStatus){
        sessionStatus.setComplete();
        UserResp userResp = new UserResp();
        userResp.setCode(1);
        return userResp;
    }

    @RequestMapping(value = "/userInfo",method = RequestMethod.GET)
    public OrderResp userInfo(ModelMap modelMap){
        User user =(User) modelMap.get("user");
        OrderResp orderResp = new OrderResp();
        orderResp.setCode(1);
        orderResp.setInfo(user);
        return orderResp;
    }

    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    public UserResp updateTel(User user){
        Integer integer = userService.updateUser(user);
        UserResp userResp = new UserResp();
        if (integer == 1){
            userResp.setCode(1);
            return userResp;
        }
        userResp.setCode(0);
        userResp.setInfo("修改失败");
        return userResp;
    }

}
