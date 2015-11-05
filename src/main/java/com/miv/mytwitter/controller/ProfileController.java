package com.miv.mytwitter.controller;


import com.miv.mytwitter.domain.User;
import com.miv.mytwitter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.security.Principal;

@Controller
public class ProfileController {

    @Autowired
    UserService userService;

//    @RequestMapping(value = "/{login}", method = RequestMethod.GET)
//    @ResponseBody
//    @Transactional
//    public String getProfile(final HttpServletRequest request, Principal principal, Model model){
//        final String currentUserLogin = principal.getName();
//        User user = userService.findByLogin(currentUserLogin);
//        return "profile";
//    }
//
//    @RequestMapping(value = "/{login}/following", method = RequestMethod.GET)
//    @ResponseBody
//    @Transactional
//    public ModelAndView getFollowing(@PathVariable("login") String login, HttpServletRequest request, HttpServletResponse response) {
//        return getModelAndViewProfile(login,"following");
//    }
//
//
//    @RequestMapping(value = "/{login}/followers", method = RequestMethod.GET)
//    @ResponseBody
//    @Transactional
//    public ModelAndView getFollowers(@PathVariable("login") String login, HttpServletRequest request, HttpServletResponse response) {
//        return getModelAndViewProfile(login,"followers");
//    }
//
//    @Transactional
//    public ModelAndView getModelAndViewProfile(String login, String tab){
//        ModelAndView modelAndView = new ModelAndView("profile_page");
//        modelAndView.addObject("user", userService.findByLogin(login));
//        modelAndView.addObject("tab", tab);
//        return modelAndView;
//    }
}
