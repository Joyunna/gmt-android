package com.example.gmt;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;


public class PosterPagerAdapter extends FragmentPagerAdapter {

    private List<MovieVO> movieList;

    public PosterPagerAdapter(FragmentManager fragmentManager, List<MovieVO> movieList) {
        super(fragmentManager);
//        posters = new ArrayList<>();
//        posters.add(R.drawable.dongwon);
//        posters.add(R.drawable.hyun);
//        posters.add(R.drawable.jong);

        if (movieList == null) {
            this.movieList = new ArrayList<>();
            return;
        }
        this.movieList = movieList;
    }

    public int getCount() {
        return movieList.size();
    }

    @Override
    public Fragment getItem(int position) {
        PosterFragment fragment = new PosterFragment();
        fragment.setMovieVO(movieList.get(position));
        return fragment;
    }
}
