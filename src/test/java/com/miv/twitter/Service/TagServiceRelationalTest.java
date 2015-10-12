package com.miv.twitter.Service;

import com.miv.mytwitter.MyTwitterApplication;
import com.miv.mytwitter.domain.Tag;
import com.miv.mytwitter.service.TagService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static junit.framework.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MyTwitterApplication.class)
@WebAppConfiguration
public class TagServiceRelationalTest {

    @Autowired
    TagService tagService;

    @Test
    public void test(){

        Tag tag1 = tagService.save("Best");
        Tag tag2 = tagService.save("Best");
        assertTrue(tag1.equals(tag2));

    }

}
