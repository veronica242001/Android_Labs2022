package com.example.myapp.lab3;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {User.class}, version =1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract UserDao userDao();
}
