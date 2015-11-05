package com.miv.mytwitter.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Tweets")
public class Tweet extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;

    @Column(nullable = false)
    private String text;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner")
    private User owner;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "TweetsTags",
            joinColumns =
            @JoinColumn(name = "Tag"),
            inverseJoinColumns =
            @JoinColumn(name = "Tweet")
    )
    private Set<Tag> tags = new HashSet<Tag>();
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "Mentions",
            joinColumns =
            @JoinColumn(name = "User"),
            inverseJoinColumns =
            @JoinColumn(name = "Tweet")
    )
    private Set<User> mentions = new HashSet<User>();

    @Column
    private Tweet source;

    protected Tweet() {
    }

    public Tweet(User owner, String text) {
        this.owner = owner;
        this.text = text;
    }

    public void clearTags(){
        tags = new HashSet<Tag>();
    }

    public void addTag(Tag tag){
        tags.add(tag);
    }

    public void clearMentions(){
        mentions = new HashSet<User>();
    }

    public void addMention(User mention){
        mentions.add(mention);
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

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

    public Tweet getSource() {
        return source;
    }

    public void setSource(Tweet source) {
        this.source = source;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tweet tweet = (Tweet) o;

        if (getId() != null ? !getId().equals(tweet.getId()) : tweet.getId() != null) return false;
        return !(owner != null ? !owner.equals(tweet.owner) : tweet.owner != null);

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        return result;
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "text='" + text + '\'' +
                '}';
    }

}
