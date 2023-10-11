package com.reivai.movielist.network.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.reivai.movielist.network.model.MovieModel;

public class MovieResponse {

    @Expose
    @SerializedName("result")
    private MovieModel result;

    public MovieModel getResult() {
        return result;
    }

    public void setResult(MovieModel result) {
        this.result = result;
    }
}
