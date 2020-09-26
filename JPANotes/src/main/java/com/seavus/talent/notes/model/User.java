package com.seavus.talent.notes.model;


import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String username;
    private String password;


    public User() {
    }

    public User(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }


    public String getPassword() {
        return password;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
