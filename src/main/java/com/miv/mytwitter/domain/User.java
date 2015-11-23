package com.miv.mytwitter.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.miv.mytwitter.domain.enums.UserRoleEnum;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
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

    @NotNull
    @Pattern(regexp = "^[a-z0-9]*$")
    @Size(min = 1, max = 50)
    @Column(length = 50, unique = true, nullable = false)
    private String login;

    @JsonIgnore
    @NotNull
    @Size(min = 60, max = 60)
    @Column(length = 60)
    private String password;

    @Size(max = 50)
    @Column(name = "first_name", length = 50)
    private String firstName;

    @Size(max = 50)
    @Column(name = "last_name", length = 50)
    private String lastName;

    @Email
    @Size(max = 100)
    @Column(length = 100, unique = true)
    private String email;

    @Column(nullable = false)
    private boolean activated = false;

    @Size(min = 2, max = 5)
    @Column(name = "lang_key", length = 5)
    private String langKey;

    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRoleEnum role;

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
    private Set<User> followings;

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
        this.login = login;
        this.password = password;
        this.followers = new HashSet<User>();
        this.followings = new HashSet<User>();
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

    public UserRoleEnum getRole() {
        return role;
    }

    public void setRole(UserRoleEnum role) {
        this.role = role;
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
        return followings;
    }

    public void removeFollowing(User following) {
        followings.remove(following);
    }

    public void setFollowing(User following) {
        if (following != null) {
            if (this.followings == null) {
                this.followings = new HashSet<User>();
            }
            this.followings.add(following);
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public String getLangKey() {
        return langKey;
    }

    public void setLangKey(String langKey) {
        this.langKey = langKey;
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
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", activated=" + activated +
                ", langKey='" + langKey + '\'' +
                '}';
    }

}
