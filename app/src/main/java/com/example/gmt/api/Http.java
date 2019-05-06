package com.example.gmt.api;

import com.example.gmt.MainActivity;
import com.example.gmt.adapter.PosterPagerAdapter;
import com.example.gmt.dto.MovieVO;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class Http {

    public void requestMovies(final MainActivity mainActivity) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MovieRequestSpec.URL)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        MovieRequestSpec movieRequestSpec = retrofit.create(MovieRequestSpec.class);
        List<MovieVO> movies = null;
        movieRequestSpec
                .getMovies()
                .enqueue(new Callback<List<MovieVO>>() {
                    @Override
                    public void onResponse(Call<List<MovieVO>> call, Response<List<MovieVO>> response) {
                        if (response.isSuccessful()) {
                            List<MovieVO> movies = response.body();
                            mainActivity.setPosterPagerAdapter(new PosterPagerAdapter(mainActivity.getSupportFragmentManager(), movies));
                        }
                    }

                    @Override
                    public void onFailure(Call<List<MovieVO>> call, Throwable t) {
                        System.out.println(t.getMessage());
                        System.out.println("Fail");
                    }
                });
    }

}
