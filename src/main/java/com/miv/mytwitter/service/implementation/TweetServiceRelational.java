package com.miv.mytwitter.service.implementation;


import com.miv.mytwitter.domain.User;
import com.miv.mytwitter.domain.Tweet;
import com.miv.mytwitter.repository.TweetRepository;
import com.miv.mytwitter.service.TagService;
import com.miv.mytwitter.service.TweetService;
import com.miv.mytwitter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class TweetServiceRelational implements TweetService {

    private static final Pattern MENTION = Pattern.compile("@(\\p{Alnum}{3,})");
    private static final Pattern TAG = Pattern.compile("#(\\p{Alnum}{3,})");

    @Autowired
    UserService userService;
    @Autowired
    TagService tagService;
    @Autowired
    TweetRepository tweetRepository;

    @Override
    public Tweet save(Tweet tweet) {
        return tweetRepository.save(tweet);
    }

    @Transactional
    public Tweet creatTweet(User owner, String text) {
        Tweet tweet = new Tweet(owner, text);
        addMentions(tweet, text);
        addTags(tweet, text);
        return save(tweet);

    }

    @Override
    public void delete(String id) {
        tweetRepository.delete(id);
    }

    public void readTweet(User owner, String text) {
        Tweet tweet = new Tweet(owner, text);
        addMentions(tweet, text);
        addTags(tweet, text);
        tweetRepository.save(tweet);
    }

    private void addMentions(Tweet tweet, String text) {

        tweet.clearMentions();
        for (String mention : extractMentions(text)) {
            User user = userService.findByLogin(mention);
            if (user != null){
                tweet.addMention(user);
            }
        }

    }

    private void addTags(Tweet tweet, String text) {

        tweet.clearTags();
        for (String tag : extractTags(text)) {
            tweet.addTag(tagService.save(tag));
        }

    }

    private Set<String> extractMentions(String text) {

        return extractTokens(text, MENTION);

    }

    private Set<String> extractTags(String text) {

        return extractTokens(text, TAG);

    }

    private Set<String> extractTokens(String text, Pattern p) {

        final Matcher matcher = p.matcher(text);
        Set<String> result = new LinkedHashSet<String>();
        while (matcher.find()) {
            result.add(matcher.group(1).toLowerCase());
        }
        return result;

    }

}
