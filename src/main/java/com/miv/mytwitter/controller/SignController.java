package com.miv.mytwitter.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class SignController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SignController.class);

    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public String getSignInPage(@RequestParam Optional<String> error) {
        LOGGER.debug("Getting sign in page, error={}", error);
        return "signin";
    }

    // Login form with error
    @RequestMapping("/signin?error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "signin";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public ModelAndView getSignUpPage(@RequestParam Optional<String> error) {
        LOGGER.debug("Getting sign up page");
        return new ModelAndView("signup");
    }

}
