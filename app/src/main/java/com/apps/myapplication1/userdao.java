package com.apps.myapplication1;

import android.database.Observable;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;




@Dao
public interface userdao{

 @Query("SELECT * FROM user_table WHERE username=:name AND password=:password ")
user getuser(String name , String password);
@Insert
 void insertuser(user usr);
}
