package com.miv.mytwitter.spring.controller;


import com.miv.mytwitter.spring.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

@Controller
public class ProfileController {
    @Autowired
    UserRepository repository;

    @RequestMapping(value = "/{login}", method = RequestMethod.GET)
    @ResponseBody
    @Transactional
    public ModelAndView getProfile(@PathVariable("login") String login, HttpServletRequest request, HttpServletResponse response) {
        return getModelAndViewProfile(login,"twits");

    }

    @RequestMapping(value = "/{login}/following", method = RequestMethod.GET)
    @ResponseBody
    @Transactional
    public ModelAndView getFollowing(@PathVariable("login") String login, HttpServletRequest request, HttpServletResponse response) {
        return getModelAndViewProfile(login,"following");

    }

    @RequestMapping(value = "/{login}/followers", method = RequestMethod.GET)
    @ResponseBody
    @Transactional
    public ModelAndView getFollowers(@PathVariable("login") String login, HttpServletRequest request, HttpServletResponse response) {
        return getModelAndViewProfile(login,"followers");

    }

    public ModelAndView getModelAndViewProfile(String login, String tab){
        ModelAndView modelAndView = new ModelAndView("profile_page");
        modelAndView.addObject("user", repository.findByLogin(login));
        modelAndView.addObject("tab", tab);
        return modelAndView;
    }
}
