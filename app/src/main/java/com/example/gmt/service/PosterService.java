package com.example.gmt.service;

import com.example.gmt.MainActivity;
import com.example.gmt.api.Http;

public class PosterService {
    private  Http http;

    public PosterService() {
        this.http = new Http();
    }
    public void refreshMovies(MainActivity mainActivity) {
        http.requestMovies(mainActivity);
    }
}
