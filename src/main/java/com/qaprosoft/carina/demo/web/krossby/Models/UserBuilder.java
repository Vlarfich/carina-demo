package com.qaprosoft.carina.demo.web.krossby.Models;

import com.qaprosoft.carina.demo.web.krossby.Models.User;

public class UserBuilder {
    private User user;

    public UserBuilder() {
        user = new User(" ", " ");
    }

    public UserBuilder username(String username) {
        user.setUserName(username);
        return this;
    }

    public UserBuilder password(String pass) {
        user.setPassword(pass);
        return this;
    }


    public User build() {
        return user;
    }
}
