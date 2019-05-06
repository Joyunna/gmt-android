package com.example.gmt.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gmt.R;
import com.example.gmt.dto.MovieVO;

public class PosterFragment extends Fragment {

    private MovieVO movieVO;

    public void setMovieVO(MovieVO movieVO) {
        this.movieVO = movieVO;
    }

    public MovieVO getMovieVO() {
        return movieVO;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fragment_poster, container, false);
        ImageView imageView = view.findViewById(R.id.movie_poster);
        TextView movieName = view.findViewById(R.id.movie_name);

        movieName.setText(movieVO.getName());
        return view;
    }
}
