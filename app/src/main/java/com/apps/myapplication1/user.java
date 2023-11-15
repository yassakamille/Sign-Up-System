package com.apps.myapplication1;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "user_table")
public class user implements Serializable {
@PrimaryKey(autoGenerate = true)
@NonNull
private int id;
private String username;
private String  password;


    public user(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void setId( @NonNull int id) {
        this.id = id;
    }
    @NonNull



    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
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
        return "user{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
