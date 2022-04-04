package com.example.myapp.lab3;

import android.app.Application;

import androidx.room.Room;

public class MyApplication extends Application {

    private static AppDatabase mAppDatabase;
    public static MyApplication mInstance;

    @Override
    public void onCreate(){
        super.onCreate();

        mInstance = this;
        mAppDatabase = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "database-name").build();
    }

    public static AppDatabase getmAppDatabase() {
        return mAppDatabase;
    }

    public static MyApplication getmInstance() {
        return mInstance;
    }
    //!!!! de amintit ca de fiecare data cand cream noi activitati trebuie sa le adaugam in manifest pt ca aplicatia sa stie de ele


}
