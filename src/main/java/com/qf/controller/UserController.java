package com.qf.controller;

import com.qf.pojo.User;
import com.qf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@ResponseBody
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginInto(User user, Model model) {

        if (user.getTel() != null && !StringUtils.isEmpty(user.getTel()) || user.getPassword() != null && !StringUtils.isEmpty(user.getPassword())) {

            User users = userService.login(user);
            if (users != null) {
                model.addAttribute("users", users);
                return "{\"code\":1}";
            } else {
                return null;
            }
        }
        return null;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerInto(User user) {
        System.out.println(user);
        Integer users = userService.register(user);
        System.out.println(users);
        if (users == 1) {
            return "{\"code\":1}";
        }
        return null;
    }
}