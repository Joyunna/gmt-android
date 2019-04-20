package com.example.gmt;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.net.URL;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

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
        //imageView.setImageBitmap(BitmapFactory.decodeResource(getResources(), poster));

        final String thumbnailUri = "http://172.30.1.55:8080/movies/thumbnail?thumbnail=" + movieVO.getThumbnail();
        Future<Bitmap> bitmapFuture = Executors.newFixedThreadPool(1)
                .submit(new Callable<Bitmap>() {
                    @Override
                    public Bitmap call() throws Exception {
                        URL url = new URL(thumbnailUri);
                        return BitmapFactory.decodeStream(url.openStream());
                    }
                });
        try {
            imageView.setImageBitmap(bitmapFuture.get());
        } catch (InterruptedException e) {

        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return view;
    }
}
