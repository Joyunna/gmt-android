package com.example.gmt;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Http {
    public List<MovieVO> getMovies() {

        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<List<MovieVO>> movies = executorService.submit(new Callable<List<MovieVO>>() {
            @Override
            public List<MovieVO> call() throws Exception {
                List<MovieVO> movieVOs = null;
                try {
                    String strUrl = "http://172.30.1.55:8080/movies";
                    URL url = new URL(strUrl);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setConnectTimeout(100000);
                    connection.setReadTimeout(100000);
                    connection.setDoInput(true);
                    connection.setDoOutput(false);
                    connection.setRequestProperty("content-type", "application/json; charset=utf-8");

                    int responseCode = connection.getResponseCode();
                    if (responseCode == 200) {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                        String jsonSource = "";
                        while (true) {
                            String src = bufferedReader.readLine();
                            if (src == null) break;
                            jsonSource += src;
                        }
                        JSONArray jsonArray = new JSONArray(jsonSource);
                        movieVOs = new ArrayList<>();
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject = new JSONObject(jsonArray.getString(i));
                            MovieVO movieVO = new MovieVO(jsonObject.getLong("id"), jsonObject.getString("name"), jsonObject.getString("thumbnail"));
                          movieVOs.add(movieVO);
                        }

                        bufferedReader.close();
                    }

                    connection.disconnect();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {

                }
                return movieVOs;
            }
        });

        try {
            return movies.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }
}
