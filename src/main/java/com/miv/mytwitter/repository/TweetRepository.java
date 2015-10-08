package com.miv.mytwitter.repository;


import com.miv.mytwitter.model.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TweetRepository extends JpaRepository<Tweet, String> {

    List<Tweet> findAll();

}
