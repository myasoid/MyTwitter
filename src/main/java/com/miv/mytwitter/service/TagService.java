package com.miv.mytwitter.service;


import com.miv.mytwitter.domain.Tag;

public interface TagService extends BaseEntityService<Tag> {

    Tag save(String text);


}
