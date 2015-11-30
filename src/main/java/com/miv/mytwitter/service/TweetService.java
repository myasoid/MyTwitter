package com.miv.mytwitter.service;

import com.miv.mytwitter.domain.Tweet;
import com.miv.mytwitter.domain.User;
import com.miv.mytwitter.domain.validator.TweetCreateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;

public interface TweetService extends BaseEntityService<Tweet> {

    Tweet creatTweet(User owner, String text);

    Tweet create(TweetCreateForm form);

    Page<Tweet> findTweetByOwner(User user, Pageable page);

    Page<Tweet> findTweetByOwnerIn(Collection<User> users, Pageable page);

}
