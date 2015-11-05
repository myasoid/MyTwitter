package com.miv.mytwitter.controller;

import com.miv.mytwitter.domain.User;
import com.miv.mytwitter.domain.validator.TweetCreateForm;
import com.miv.mytwitter.domain.validator.TweetCreateFormValidator;
import com.miv.mytwitter.service.TweetService;
import com.miv.mytwitter.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class TweetController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SignUpController.class);
    private final TweetService tweetService;
    private final UserService userService;
    private final TweetCreateFormValidator tweetCreateFormValidator;



    @Autowired
    public TweetController(TweetService tweetService, TweetCreateFormValidator tweetCreateFormValidator, UserService userService) {
        this.tweetService = tweetService;
        this.tweetCreateFormValidator = tweetCreateFormValidator;
        this.userService = userService;
    }

    @InitBinder("tweetForm")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(tweetCreateFormValidator);
    }

    @RequestMapping(value = "/tweet/create", method = RequestMethod.POST)
    public void handleTweetCreateForm(@Valid @ModelAttribute("tweetForm") TweetCreateForm form, Errors errors, Principal principal) {
        LOGGER.debug("Processing tweet create form={}, bindingResult={}", form, errors);
        final String currentUserLogin = principal.getName();
        User user = userService.findByLogin(currentUserLogin);
        form.setOwner(user);
        try {
            tweetService.create(form);
        } catch (DataIntegrityViolationException e) {
            LOGGER.warn("Exception occurred when trying to save the tweet", e);
            errors.reject("tweet.exists", " .........");
        }
    }


}
