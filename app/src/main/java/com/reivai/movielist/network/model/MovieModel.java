package com.reivai.movielist.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieModel {

    @Expose
    @SerializedName("total_results")
    public int total_results;

    @Expose
    @SerializedName("total_pages")
    public int total_pages;

    @Expose
    @SerializedName("results")
    public List<ResultsModel> results;

    @Expose
    @SerializedName("page")
    public int page;

    public int getTotal_results() {
        return total_results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public List<ResultsModel> getResults() {
        return results;
    }

    public void setResults(List<ResultsModel> results) {
        this.results = results;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
