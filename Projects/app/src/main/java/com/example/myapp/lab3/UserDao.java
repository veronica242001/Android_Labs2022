package com.example.myapp.lab3;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao // data access objects
public interface UserDao {

    @Insert
    void insertAll(User... users); // nu stim cati useri vom insera

    @Update
    void updateUsers(User... users);

    @Delete
    void delete(User user);

    @Query("SELECT * FROM user")
    List<User> getAll();

    @Query("SELECT * FROM user WHERE firstName LIKE:search OR lastName LIKE:search LIMIT 1")
    User findUserWithName(String search);



}
