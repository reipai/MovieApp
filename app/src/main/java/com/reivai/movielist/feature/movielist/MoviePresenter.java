package com.reivai.movielist.feature.movielist;

import android.content.Context;

import com.reivai.movielist.network.NetworkClient;
import com.reivai.movielist.network.model.MovieModel;
import com.reivai.movielist.network.response.MovieResponse;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.HttpException;

public class MoviePresenter implements MoviePresenterImp {

    MovieView view;
    Context context;

    public MoviePresenter(MovieView view, Context context) {
        this.view = view;
        this.context = context;
    }

    @Override
    public void getMovie(String apikey) {
        final Observable<MovieModel> movieApi = NetworkClient.getNetworkClient(context)
                .getMovieList(apikey)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        DisposableObserver<MovieModel> ma = movieApi.subscribeWith(new DisposableObserver<MovieModel>() {
            @Override
            public void onNext(MovieModel response) {
                view.success(response);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }
}
