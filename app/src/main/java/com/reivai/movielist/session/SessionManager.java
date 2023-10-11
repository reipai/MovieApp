package com.reivai.movielist.session;

import com.reivai.movielist.network.model.ResultsModel;

import java.util.ArrayList;
import java.util.List;

public interface SessionManager {

    void saveMovie(ArrayList<ResultsModel> model);

    ArrayList<ResultsModel> getMovie();

    void clear();
}
