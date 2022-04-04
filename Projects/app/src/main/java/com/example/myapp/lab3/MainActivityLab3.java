package com.example.myapp.lab3;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapp.R;

public class MainActivityLab3 extends AppCompatActivity implements  UserOperations{

    public final static String PREFERENCES_KEY = "preferences key";
    public final static String PREFERENCES_ID_KEY = "preferences id key";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lab3);

        findViewById(R.id.button).setOnClickListener( view -> insertUsers());

        findViewById(R.id.button_getName).setOnClickListener( view ->
                new FindUserOperation(this).execute("Dima")
        );
    }

    private void makePreferences() {
        //mai intai accesam contextul aplicatiei
        Context context = getApplicationContext();
        // trebuie sa ii transmite o cheie(nume) si un mod de citire/scriere
        SharedPreferences sp = getSharedPreferences(PREFERENCES_KEY, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sp.edit();
        editor.putInt(PREFERENCES_ID_KEY, 10);
        editor.apply();

        int id = sp.getInt(PREFERENCES_ID_KEY, 0);
        Toast.makeText(this, id, Toast.LENGTH_LONG).show();// un fel de pop-up care apare si dispare automat in functie de perioada pe care o setam

    }
        private void insertUsers(){
            User user1 = new User(1,"Mircea","Pop",19);
            User user2 = new User(2,"Amelia","Dima",21);

            User[] users = new User[] {user1, user2};

            new InsertUserOperation(this).execute(users);

        }


    // de obicei, lucrul cu baza de date este destul de costisitor si de aceea vrem sa il facem in background
    private void insertTask() { }

    @Override
    public void insertUsers(String result) {
        if(result.endsWith("succes")){
            Toast.makeText(MyApplication.getmInstance().getApplicationContext(), "users inserted succesfully", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(MyApplication.getmInstance().getApplicationContext(), "users insert failes", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void findUser(User user) {
        if( user != null){
            Toast.makeText(this, user.firstName + " "+user.lastName + "is" +user.age, Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "User not found", Toast.LENGTH_SHORT).show();
        }
    }
}
