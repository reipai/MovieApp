package com.reivai.movielist.session;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.reivai.movielist.network.model.ResultsModel;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Session implements SessionManager{

    private final SharedPreferences mPref;
    private final SharedPreferences.Editor mEditor;

    private final String MOVIE_LIST = "MOVIE";

    @SuppressLint("CommitPrefEdits")
    public Session(Context context) {
        this.mPref = context.getSharedPreferences("movie", 0);
        this.mEditor = mPref.edit();
    }

    public static Session create(Context context) {
        return new Session(context);
    }

    @Override
    public void saveMovie(ArrayList<ResultsModel> model) {
        Gson gson = new Gson();
        String dataMovie = gson.toJson(model);
        mEditor.putString(MOVIE_LIST, dataMovie);
        mEditor.apply();
    }

    @Override
    public ArrayList<ResultsModel> getMovie() {
        Gson gson = new Gson();
        String json = mPref.getString(MOVIE_LIST, null);
        Type type = new TypeToken<ArrayList<ResultsModel>>(){}.getType();
        return gson.fromJson(json, type);
    }

//    @Override
//    public ResultsModel getMovie() {
//        Gson gson = new Gson();
//        String json = mPref.getString(MOVIE_LIST, null);
//        return gson.fromJson(json, ResultsModel.class);
//    }

    @Override
    public void clear() {
        mEditor.clear();
        mEditor.commit();
    }
}
