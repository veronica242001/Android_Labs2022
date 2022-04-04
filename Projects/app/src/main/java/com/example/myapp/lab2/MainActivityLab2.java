package com.example.myapp.lab2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapp.R;

public class MainActivityLab2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lab2);


        if (savedInstanceState == null) {
            //vom atasa fragmentul la activitate si ne folosim de FragmentManager-->creeaza o tranzactie
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true) //permite fragmentmangereului sa faca optimizari in tranzactia respectiva
                    .add(R.id.fragment_container, FirstFragment.class, null)
                    .commit(); // ca la baze de date, cand facem o tranzactie, trebuie sa i dam commit sa fie permanente operatiile pe care le facem
        }
    }
}
