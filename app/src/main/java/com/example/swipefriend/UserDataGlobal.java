package com.example.swipefriend;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class UserDataGlobal
{
    public static UserDataGlobal instance = new UserDataGlobal();

    private String email,  username, bio;
    private int avatar_index;
    private List<String> answers;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public int getAvatar_index() {
        return avatar_index;
    }

    public void setAvatar_index(int avatar_index) {
        this.avatar_index = avatar_index;
    }


private UserDataGlobal ()
{

}
    public static UserDataGlobal getInstance() {
        return instance;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }
}
