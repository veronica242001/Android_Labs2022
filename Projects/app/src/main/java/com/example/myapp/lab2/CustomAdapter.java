package com.example.myapp.lab2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapp.R;

import java.util.List;

//am definit aceasta clasa pentru a preciza cum si ce date trebuie sa introduca in lista noastra
public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MovieViewHolder> {

    private List<MovieModel> localDataSet;
    public static OnItemClickListener itemClickListener;

    public CustomAdapter(List<MovieModel> localDataSet, OnItemClickListener itemClickListener) {
        this.localDataSet = localDataSet;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override  // trebuie sa facem legatura din ui definit mai devreme(ca si intreg) si logica
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //luam o referinta
        //ca si la fragment nu exista un context si de asta ne folosim de LoyoutInflater
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);
        return  new MovieViewHolder(view);
    }

    @Override // ne introduce datele in elementele create
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
    holder.bind(localDataSet.get(position));
    }

    @Override // cate elemente ne asteptam sa afiseze
    public int getItemCount() {
        return localDataSet.size();
    }

    //asa inseram/injectam datele in ui
    public static class MovieViewHolder extends RecyclerView.ViewHolder{ // seteaza elementele
        private final TextView title;
        private final TextView duration;
        private final ImageView movieImage;

        private final ConstraintLayout layout;

        // luam referintele catre aceste elemente din ui
        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.movie_title);
            duration = itemView.findViewById(R.id.tv_duration);
            movieImage = itemView.findViewById(R.id.iv_picture);
            layout = itemView.findViewById(R.id.container);
        }
        public void bind(MovieModel item){
            title.setText(item.getTitle());
            duration.setText(item.getDuration());

            movieImage.setImageDrawable(ContextCompat.getDrawable(movieImage.getContext(), item.getImageId()));
            layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    itemClickListener.onItemclick(item);
                }
            });
        }

    }
}
