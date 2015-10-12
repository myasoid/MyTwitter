package com.miv.mytwitter.controller;

import com.miv.mytwitter.domain.UserCreateForm;
import com.miv.mytwitter.domain.validator.UserCreateFormValidator;
import com.miv.mytwitter.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class UserController {


    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;
    private final UserCreateFormValidator userCreateFormValidator;

    @Autowired
    public UserController(UserService userService, UserCreateFormValidator userCreateFormValidator) {
        this.userService = userService;
        this.userCreateFormValidator = userCreateFormValidator;
    }

    @InitBinder("form")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(userCreateFormValidator);
    }

//    @PreAuthorize("@currentUserServiceImpl.canAccessUser(principal, #id)")
//    @RequestMapping("/user/{id}")
//    public ModelAndView getUserPage(@PathVariable Long id) {
//        LOGGER.debug("Getting user page for user={}", id);
//        return new ModelAndView("user", "user", userService.getUserById(id)
//                .orElseThrow(() -> new NoSuchElementException(String.format("User=%s not found", id))));
//    }

//    @PreAuthorize("hasAuthority('ADMIN')")


    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
    public ModelAndView handleUserCreateForm(@Valid @ModelAttribute("form") UserCreateForm form, BindingResult bindingResult) {
        LOGGER.debug("Processing user create form={}, bindingResult={}", form, bindingResult);
        if (bindingResult.hasErrors()) {
            // failed validation
            ModelAndView view = new ModelAndView("signup_up", "error", bindingResult.toString());
//            view.addObject("bindingResult", bindingResult);
            return view;

        }
        try {
            userService.create(form);
        } catch (DataIntegrityViolationException e) {
            // probably email already exists - very rare case when multiple admins are adding same user
            // at the same time and form validation has passed for more than one of them.
            LOGGER.warn("Exception occurred when trying to save the user, assuming duplicate email", e);
            bindingResult.reject("login.exists", "Login already exists");
            return new ModelAndView("signup_page", "bindingResult", bindingResult);
        }
        // ok, redirect
        return new ModelAndView("redirect:/");
    }

}
