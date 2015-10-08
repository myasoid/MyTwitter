package com.miv.mytwitter.controller;

import com.miv.mytwitter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public String addUser(@RequestParam(value = "name") String name,
                          @RequestParam(value = "login") String login,
                          @RequestParam(value = "password") String password,
                          HttpServletRequest request,
                          HttpServletResponse response) {

        userService.creatUser(name, login, password);
        return "redirect:/" + login;

    }
}
