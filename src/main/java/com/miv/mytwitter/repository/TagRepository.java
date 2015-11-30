package com.miv.mytwitter.repository;

import com.miv.mytwitter.domain.Tag;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepository extends PagingAndSortingRepository<Tag, String> {

    List<Tag> findByValue(String value);

}
