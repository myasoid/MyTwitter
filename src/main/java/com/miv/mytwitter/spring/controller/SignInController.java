package com.miv.mytwitter.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SignInController{

        @RequestMapping(value = "/signin", method = RequestMethod.GET)
        @ResponseBody
        public ModelAndView signIn() {

            return new ModelAndView("signin_page");

        }
}
