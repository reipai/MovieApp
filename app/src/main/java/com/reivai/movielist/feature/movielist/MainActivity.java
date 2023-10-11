package com.reivai.movielist.feature.movielist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.os.Bundle;

import com.reivai.movielist.databinding.ActivityMainBinding;
import com.reivai.movielist.network.model.ErrorModel;
import com.reivai.movielist.network.model.MovieModel;
import com.reivai.movielist.network.model.ResultsModel;
import com.reivai.movielist.network.response.MovieResponse;
import com.reivai.movielist.session.Session;
import com.reivai.movielist.utils.GlobalFunction;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class MainActivity extends AppCompatActivity implements MovieView{

    private ActivityMainBinding binding;
    private List<ResultsModel> movieList;
    private SweetAlertDialog alertDialog;
    private GlobalFunction globalFunction;
    private MoviePresenter presenter;
    private MovieAdapter adapter;
    private Context context;
    private Session session;
    String apikey = "f7b67d9afdb3c971d4419fa4cb667fbf";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        context = this;
        session = new Session(context);
        movieList = new ArrayList<>();
        globalFunction = new GlobalFunction(context);
        presenter = new MoviePresenter(this, context);
        adapter = new MovieAdapter(context, movieList);

        binding.rvmovie.setLayoutManager(new LinearLayoutManager(context));
        binding.rvmovie.setHasFixedSize(true);
        binding.rvmovie.setAdapter(adapter);

        binding.swipeLayout.setOnRefreshListener(direction -> {
            if (globalFunction.isNetworkAvailable()) {
                loadMovie();
            } else {
                binding.swipeLayout.setRefreshing(false);
            }
        });

        if (globalFunction.isNetworkAvailable()) {
            loadMovie();
        } else {
            session.getMovie();
            movieList.addAll(session.getMovie());
        }
    }

    public void loadMovie() {
        presenter.getMovie(apikey);
    }

    @Override
    public void success(MovieModel response) {
        movieList.clear();
        binding.swipeLayout.setRefreshing(false);
        if (response.getResults() != null) {
            movieList.addAll(response.getResults());
            session.saveMovie((ArrayList<ResultsModel>) response.getResults());
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void error(ErrorModel error) {
        String message = error.getStatus_message();
        if (!isFinishing()) {
            alertDialog = new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE);
            alertDialog.setTitleText("Kesalahan Data")
                    .setContentText(message)
                    .show();
        }
    }

}