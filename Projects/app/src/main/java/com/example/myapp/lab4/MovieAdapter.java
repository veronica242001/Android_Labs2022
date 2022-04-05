package com.example.myapp.lab4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapp.R;
import com.example.myapp.databinding.ItemMovieLab4Binding;
import com.example.myapp.lab2.CustomAdapter;
import com.squareup.picasso.Picasso;
import java.util.List;


//--
public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {


    private List<MovieModel> localDataSet;
    public void submitList(List<MovieModel> dataSet) {
        localDataSet = dataSet;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //luam o referinta
        //ca si la fragment nu exista un context si de asta ne folosim de LoyoutInflater
        // View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie_lab4, parent, false);
        //return  new MovieAdapter.MovieViewHolder(view);
        // -- var 2
        return new MovieViewHolder(DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.item_movie_lab4,
                parent,
                false)
        );

    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
       holder.bind(localDataSet.get(position));
    }

    @Override
    public int getItemCount() {
        if(localDataSet == null)
            return 0;
        return localDataSet.size();
    }
    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        private final ItemMovieLab4Binding binding;

        public MovieViewHolder(ItemMovieLab4Binding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(MovieModel item) {
            binding.title.setText(item.getTitle());
            binding.year.setText(item.getYear());
            Picasso.get().load(item.getPoster()).into(binding.image);
        }
    }
    }

