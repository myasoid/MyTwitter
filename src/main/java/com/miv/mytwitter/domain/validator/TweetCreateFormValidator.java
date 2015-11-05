package com.miv.mytwitter.domain.validator;

import com.miv.mytwitter.service.TweetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Component
public class TweetCreateFormValidator implements Validator {

    private static final Logger LOGGER = LoggerFactory.getLogger(TweetCreateFormValidator.class);
    private final TweetService tweetService;

    @Autowired
    public TweetCreateFormValidator(TweetService tweetService) {
        this.tweetService = tweetService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(TweetCreateForm.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        LOGGER.info("Validating {}", target);
    }

}
