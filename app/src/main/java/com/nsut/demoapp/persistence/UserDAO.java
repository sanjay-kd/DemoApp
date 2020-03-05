package com.nsut.demoapp.persistence;

import com.nsut.demoapp.model.User;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
interface UserDAO {

    @Insert
    void insertUserData(User user);

    @Query("SELECT * FROM Users")
    List<User> getSavedUsersLists();

    @Query("SELECT * FROM Users where age =:age")
    List<User> getSavedUsersListsByAge(String age);

}
