package com.nsut.demoapp.persistence;

import android.content.Context;
import android.os.AsyncTask;

import com.nsut.demoapp.model.User;

import java.util.List;
import java.util.logging.Handler;

public class UserRepository {

    private UserDatabase userDatabase;

    public UserRepository(Context context){
        userDatabase = UserDatabase.getInstance(context);
    }

    public void insertUser(final User user){
//        AsyncTask.execute(new Runnable() {
//            @Override
//            public void run() {
//                userDatabase.getUserDao().insertUserData(user);
//            }
//        });

        userDatabase.getUserDao().insertUserData(user);
    }

    public void deleteUser(User user){

    }

    public List<User> getTableData(){
        return userDatabase.getUserDao().getSavedUsersLists();
    }

}
