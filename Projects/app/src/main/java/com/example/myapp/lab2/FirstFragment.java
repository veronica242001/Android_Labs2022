package com.example.myapp.lab2;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapp.R;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment implements OnItemClickListener {

    public static List<MovieModel> movieList = new ArrayList<>();

    public static String MOVIE_TITLE = "movie title";
    public static String MOVIE = "movie";

    //  pentru a atasa layout ul la fragment folosim un constructor
    public FirstFragment(){
        super(R.layout.fragment_first);}

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // vom face initializarile de care vom avea nevoie

        initializeMovieList();
        CustomAdapter adapter = new CustomAdapter(movieList, this);
        RecyclerView rv = view.findViewById(R.id.recycler_view); // vom lua referinta de la element
        rv.setAdapter(adapter);
    }

    private void initializeMovieList(){
        movieList.add(new MovieModel(
                "Avengers: Infinity War",
                "108min",
                R.drawable.avengers
        ));
        movieList.add(new MovieModel(
                "Green book",
                "130min",
                R.drawable.greenbook
        ));
    }

    @Override
    public void onItemclick(MovieModel item) {
        //vrem sa transmitem ca si parametru catre cel de-al doilea fragment, datele filmului; la activitati aveam Intents, dar la frag nu avem
        // functioneaza pe acelasi principiu, de tip cheie valoare
        Bundle bundle = new Bundle();

        bundle.putString(MOVIE_TITLE, item.getTitle()); // dar putem pune si obiecte in sine, serializate sub forma de la string
        bundle.putParcelable(MOVIE,item);

        //pentru ca in fragment nu exista un context de sine statator, mai intai luam activitatea
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        SecondFragment secondFragment = new SecondFragment();
        secondFragment.setArguments(bundle);

        //folosim replace pentru ca la acest moment avem deja un fragment inserat si vrem doar sa il inlocuim
        fragmentTransaction.replace(R.id.fragment_container, secondFragment)
            .addToBackStack(null);
        fragmentTransaction.commit();
    }
}
