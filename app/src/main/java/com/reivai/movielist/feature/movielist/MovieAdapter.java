package com.reivai.movielist.feature.movielist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.reivai.movielist.R;
import com.reivai.movielist.network.model.ResultsModel;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    private Context context;
    private List<ResultsModel> movieList;

    public MovieAdapter(Context context, List<ResultsModel> movieList) {
        this.context = context;
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public MovieAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.ViewHolder holder, int position) {
        ResultsModel listData =  movieList.get(position);

        if (listData != null) {
            Glide.with(context)
                    .load("https://www.themoviedb.org/t/p/w600_and_h900_bestv2" + listData.getPoster_path())
                    .into(holder.imgMovie);

            holder.titleMovie.setText(listData.getTitle());
            holder.releaseMovie.setText(listData.getRelease_date());
            holder.overviewMovie.setText(listData.getOverview());

            holder.itemView.setOnClickListener(v -> {

            });
        }
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgMovie;
        TextView titleMovie, releaseMovie, overviewMovie;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgMovie = itemView.findViewById(R.id.imgmovie);
            titleMovie = itemView.findViewById(R.id.title_movie);
            releaseMovie = itemView.findViewById(R.id.releasedate_movie);
            overviewMovie = itemView.findViewById(R.id.overview_movie);
        }
    }
}
