package com.miv.mytwitter.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class SignController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SignController.class);

    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public ModelAndView getSignInPage(@RequestParam Optional<String> error) {
        LOGGER.debug("Getting sign in page, error={}", error);
//        return new ModelAndView("signin_page", "error", error.get());
        return new ModelAndView("signin_page");
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public ModelAndView getSignUpPage(@RequestParam Optional<String> error) {
        LOGGER.debug("Getting sign up page");
        return new ModelAndView("signup_page", "error", error.get());
    }

}
