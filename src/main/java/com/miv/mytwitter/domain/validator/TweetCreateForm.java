package com.miv.mytwitter.domain.validator;

import com.miv.mytwitter.domain.User;
import org.hibernate.validator.constraints.NotEmpty;

public class TweetCreateForm {

    @NotEmpty
    private String text;

    private User owner;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "TweetCreateForm{" +
                "text='" + text + '\'' +
                ", owner=" + owner +
                '}';
    }
}
