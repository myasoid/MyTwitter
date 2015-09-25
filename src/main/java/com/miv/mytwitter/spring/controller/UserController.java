package com.miv.mytwitter.spring.controller;

import com.miv.mytwitter.model.User;
import com.miv.mytwitter.spring.data.UserRepository;
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
    UserRepository repository;

    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public String addUser(@RequestParam(value = "name") String name,
                          @RequestParam(value = "login") String login,
                          @RequestParam(value = "password") String password,
                          HttpServletRequest request,
                          HttpServletResponse response) {

        User user = new User(name, login, password);
        repository.save(user);
        return "redirect:/" + login;

    }
}
