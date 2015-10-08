package com.miv.mytwitter.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Users")
public class User extends AbstractBaseEntity {

    public static final int EMAIL_MAX = 250;
    public static final int NAME_MAX = 50;
    public static final int RANDOM_CODE_LENGTH = 16;
    public static final int PASSWORD_MAX = 30;

    private static final long serialVersionUID = 1L;

    @Column(unique = true, nullable = false)
    private String login;
    @Column
    private String password;

    //@Size(min = 3, max = 200)
    @Column
    private String name;

    @Lob
    private byte[] avatar;
    @Lob
    private byte[] profileCover;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private Set<Tweet> tweets;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "Followers",
            joinColumns =
            @JoinColumn(name = "Follower"),
            inverseJoinColumns =
            @JoinColumn(name = "User")
    )
    private Set<User> following;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "Followers",
            joinColumns =
            @JoinColumn(name = "User"),
            inverseJoinColumns =
            @JoinColumn(name = "Follower")
    )
    private Set<User> followers;

    public User() {
    }

    public User(String login) {
        this.login = login;
    }

    public User(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.followers = new HashSet<User>();
        this.following = new HashSet<User>();
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }

    public byte[] getProfileCover() {
        return profileCover;
    }

    public void setProfileCover(byte[] profileCover) {
        this.profileCover = profileCover;
    }

    public Set<Tweet> getTwits() {
        return tweets;
    }

    public void setTwits(Set<Tweet> twits) {
        this.tweets = twits;
    }

    public Set<User> getFollowings() {
        return following;
    }

    public void setFollowing(User following) {
        if (following != null) {
            if (this.following == null) {
                this.following = new HashSet<User>();
            }
            this.following.add(following);
        }
    }

    public Set<User> getFollowers() {
        return followers;
    }

    public void setFollower(User follower) {
        if (follower != null) {
            if (this.followers == null) {
                this.followers = new HashSet<User>();
            }
            this.followers.add(follower);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return login.equals(user.login);

    }

    @Override
    public int hashCode() {
        return login.hashCode();
    }


    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
