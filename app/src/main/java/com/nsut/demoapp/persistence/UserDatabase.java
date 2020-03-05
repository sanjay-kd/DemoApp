package com.nsut.demoapp.persistence;

import android.content.Context;

import com.nsut.demoapp.model.User;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {User.class}, version = 1)
public abstract class UserDatabase extends RoomDatabase {

    private static String DATABASE = "DemoAppDatabase";
    private static UserDatabase instance;

    static UserDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(
                    context.getApplicationContext(),
                    UserDatabase.class,
                    DATABASE)
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
    public abstract UserDAO getUserDao();
}
