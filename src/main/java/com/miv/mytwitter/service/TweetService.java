package com.miv.mytwitter.service;

import com.miv.mytwitter.model.Tweet;
import com.miv.mytwitter.model.User;

public interface TweetService extends BaseEntityService<Tweet> {

    Tweet creatTweet(User owner,String text);

}
