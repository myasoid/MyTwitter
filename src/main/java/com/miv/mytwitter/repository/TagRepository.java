package com.miv.mytwitter.repository;

import com.miv.mytwitter.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepository extends JpaRepository<Tag, String> {

    List<Tag> findByValue(String value);

}
