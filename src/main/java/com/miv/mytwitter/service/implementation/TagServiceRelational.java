package com.miv.mytwitter.service.implementation;

import com.miv.mytwitter.service.TagService;
import com.miv.mytwitter.domain.Tag;
import com.miv.mytwitter.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceRelational implements TagService {

    @Autowired
    TagRepository tagRepository;

    @Override
    public Tag save(String value) {
        List<Tag> tags = tagRepository.findByValue(value);
        if (tags.size() > 0) {
            return tags.get(0);
        } else {
            return save(new Tag(value));
        }
    }

    @Override
    public Tag save(Tag tag) {
        return tagRepository.save(tag);
    }

    @Override
    public void delete(String id) {
        tagRepository.delete(id);
    }
}
