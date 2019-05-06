package com.example.gmt.api;

import com.example.gmt.dto.MovieVO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MovieRequestSpec {

    String URL = "http://99fa90eb.ngrok.io";

    @GET("/movies")
    Call<List<MovieVO>> getMovies();
}
