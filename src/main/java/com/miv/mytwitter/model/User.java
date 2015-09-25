package com.miv.mytwitter.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Users")
public class User extends BaseEntity {

    public static final int EMAIL_MAX = 250;
    public static final int NAME_MAX = 50;
    public static final int RANDOM_CODE_LENGTH = 16;
    public static final int PASSWORD_MAX = 30;

    private static final long serialVersionUID = 1L;

    @Column(unique = true, nullable = false)
    private String login;
    private String password;

    @Size(min = 3, max = 200)
    private String name;

    @Lob
    private byte[] avatar;
    @Lob
    private byte[] profileCover;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private Set<Twit> twits;

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

    public Set<Twit> getTwits() {
        return twits;
    }

    public void setTwits(Set<Twit> twits) {
        this.twits = twits;
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

        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (!Arrays.equals(avatar, user.avatar)) return false;
        return Arrays.equals(profileCover, user.profileCover);

    }

    @Override
    public int hashCode() {
        int result = login != null ? login.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (avatar != null ? Arrays.hashCode(avatar) : 0);
        result = 31 * result + (profileCover != null ? Arrays.hashCode(profileCover) : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                ", id='" + getId() + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
//                ", twits=" + getTwits() +
//                ", following=" + getfollowings() +
//                ", followers=" + getFollowers() +
                '}';
    }

}
