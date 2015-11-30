package com.miv.mytwitter.repository;


import com.miv.mytwitter.domain.Tweet;
import com.miv.mytwitter.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface TweetRepository extends PagingAndSortingRepository<Tweet, String> {

    Page<Tweet> findTweetByOwnerOrderByDateCreatedDesc(User user, Pageable page);

    Page<Tweet> findTweetByOwnerInOrderByDateCreatedDesc(Collection<User> users, Pageable page);

}
