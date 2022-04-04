package com.example.myapp.lab1;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapp.R;
import com.example.myapp.lab1.MainActivity;

public class SecondActivity extends AppCompatActivity { //pentru a fi activitate trebuie sa extinda clasa parinte si sa ii definim un layout



    //--- trebuie sa facem legatura intre view si logica aplicatiei
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        String message = getIntent().getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = findViewById(R.id.textView2);

        textView.setText(getString(R.string.hello) + ", " + message);
    }
}
