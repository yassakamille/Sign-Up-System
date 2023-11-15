package com.apps.myapplication1;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
@Database(entities = user.class,version = 1)
public abstract class UserDatabase extends RoomDatabase {


    private static UserDatabase instance;

    public abstract userdao userdao();

    public static synchronized UserDatabase getInstance(Context context) {

        if (instance == null) {

            instance = Room.databaseBuilder(context.getApplicationContext()
                            , UserDatabase.class, "user_database")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }

return instance;
    }
}