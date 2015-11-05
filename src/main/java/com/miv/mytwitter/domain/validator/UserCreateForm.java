package com.miv.mytwitter.domain.validator;

import com.miv.mytwitter.domain.enums.UserRoleEnum;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

public class UserCreateForm {

    @NotEmpty
    private String name = "";

    @NotEmpty
    private String login = "";

    @NotEmpty
    private String password = "";

    @NotEmpty
    private String passwordRepeated = "";

    @NotNull
    private UserRoleEnum role = UserRoleEnum.USER;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getPasswordRepeated() {
        return passwordRepeated;
    }

    public void setPasswordRepeated(String passwordRepeated) {
        this.passwordRepeated = passwordRepeated;
    }

    public UserRoleEnum getRole() {
        return role;
    }

    public void setRole(UserRoleEnum role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserCreateForm{" +
                "login='" + login.replaceFirst("@.+", "@***") + '\'' +
                ", password=***" + '\'' +
                ", passwordRepeated=***" + '\'' +
                ", role=" + role +
                '}';
    }

}
