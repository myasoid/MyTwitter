package com.miv.mytwitter.repository;


import com.miv.mytwitter.domain.Tweet;
import com.miv.mytwitter.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TweetRepository extends JpaRepository<Tweet, String> {

    Page<Tweet> findByOwner(User user, Pageable page);

//    @Query("select t from Tweet t where t.owner in (select u.following from User u where u  = :user)")
//    Page<Tweet> findByUser(@Param("user") User user, Pageable page);

}
