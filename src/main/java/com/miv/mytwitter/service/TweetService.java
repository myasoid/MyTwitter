package com.miv.mytwitter.service;

import com.miv.mytwitter.domain.Tweet;
import com.miv.mytwitter.domain.User;
import com.miv.mytwitter.domain.validator.TweetCreateForm;

public interface TweetService extends BaseEntityService<Tweet> {

    Tweet creatTweet(User owner, String text);

    Tweet create(TweetCreateForm form);
}
