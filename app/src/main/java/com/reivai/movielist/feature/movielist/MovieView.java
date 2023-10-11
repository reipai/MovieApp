package com.reivai.movielist.feature.movielist;

import com.reivai.movielist.network.model.ErrorModel;
import com.reivai.movielist.network.model.MovieModel;
import com.reivai.movielist.network.response.MovieResponse;

public interface MovieView {
    void success(MovieModel response);

    void error(ErrorModel error);
}
