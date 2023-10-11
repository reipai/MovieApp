package com.reivai.movielist.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResultsModel {
    @Expose
    @SerializedName("vote_count")
    public int vote_count;

    @Expose
    @SerializedName("vote_average")
    public double vote_average;

    @Expose
    @SerializedName("video")
    public boolean video;

    @Expose
    @SerializedName("title")
    public String title;

    @Expose
    @SerializedName("release_date")
    public String release_date;

    @Expose
    @SerializedName("poster_path")
    public String poster_path;

    @Expose
    @SerializedName("popularity")
    public double popularity;

    @Expose
    @SerializedName("overview")
    public String overview;

    @Expose
    @SerializedName("original_title")
    public String original_title;

    @Expose
    @SerializedName("original_language")
    public String original_language;

    @Expose
    @SerializedName("id")
    public int id;

    @Expose
    @SerializedName("genre_ids")
    public List<Integer> genre_ids;

    @Expose
    @SerializedName("backdrop_path")
    public String backdrop_path;

    @Expose
    @SerializedName("adult")
    public boolean adult;

    public int getVote_count() {
        return vote_count;
    }

    public void setVote_count(int vote_count) {
        this.vote_count = vote_count;
    }

    public double getVote_average() {
        return vote_average;
    }

    public void setVote_average(double vote_average) {
        this.vote_average = vote_average;
    }

    public boolean isVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Integer> getGenre_ids() {
        return genre_ids;
    }

    public void setGenre_ids(List<Integer> genre_ids) {
        this.genre_ids = genre_ids;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }
}
