package com.miv.mytwitter.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SignUpController {

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView signUp() {

        return new ModelAndView("signup_page");

    }

}
