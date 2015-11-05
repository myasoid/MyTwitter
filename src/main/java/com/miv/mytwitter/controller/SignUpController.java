package com.miv.mytwitter.controller;

import com.miv.mytwitter.domain.validator.UserCreateForm;
import com.miv.mytwitter.domain.validator.UserCreateFormValidator;
import com.miv.mytwitter.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class SignUpController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SignUpController.class);
    private final UserService userService;
    private final UserCreateFormValidator userCreateFormValidator;

    @Autowired
    public SignUpController(UserService userService, UserCreateFormValidator userCreateFormValidator) {
        this.userService = userService;
        this.userCreateFormValidator = userCreateFormValidator;
    }

    @InitBinder("signupForm")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(userCreateFormValidator);
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String getSignUpPage(Model model) {
        model.addAttribute("signupForm", new UserCreateForm());
        return "signup";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String handleUserCreateForm(@Valid @ModelAttribute("signupForm") UserCreateForm form, Errors errors) {
        LOGGER.debug("Processing user create form={}, bindingResult={}", form, errors);
        if (errors.hasErrors()) {
            return "signup";

        }
        try {
            userService.create(form);
        } catch (DataIntegrityViolationException e) {
            LOGGER.warn("Exception occurred when trying to save the user, assuming duplicate email", e);
            errors.reject("login.exists", "Login already exists");
            return "signup";
        }

        // ok, redirect
        return "/" + form.getLogin();
    }

}
