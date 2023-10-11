package com.reivai.movielist.network;

import com.reivai.movielist.network.model.MovieModel;
import com.reivai.movielist.network.response.MovieResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface NetworkApi {
    @GET("movie")
    Observable<MovieModel> getMovieList(@Query("api_key") String apikey);
}
