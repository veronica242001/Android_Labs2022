package com.example.myapp.lab2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapp.R;

public class SecondFragment extends Fragment {


     public SecondFragment() { super(R.layout.fragment_second);
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle bundle = this.getArguments();
        if (bundle != null) {
            String title = bundle.getString(FirstFragment.MOVIE_TITLE);
            ((TextView) view.findViewById(R.id.title)).setText(title);

            MovieModel movie = bundle.getParcelable(FirstFragment.MOVIE);
        }

    }
}
