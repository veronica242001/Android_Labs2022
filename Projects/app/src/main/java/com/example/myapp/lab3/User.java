package com.example.myapp.lab3;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.android.material.progressindicator.BaseProgressIndicator;

import org.jetbrains.annotations.NotNull;

@Entity //--adnotare care precizeaza ca nu este o clasa normala de java, ci defineste o entiate in baza de date
public class User {

    @PrimaryKey
    public int id;

    public String firstName;

    @NotNull
    public String lastName;
    public int age;

    public User(int id, String firstName, @NotNull String lastName, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
}
