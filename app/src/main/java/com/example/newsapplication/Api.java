package com.example.newsapplication;

import com.example.newsapplication.model.Article;
import com.example.newsapplication.model.MainBranch;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface Api {

    //"https://api.jikan.moe/v3/search/anime?q="+mAnimeNamepass;
    //https://newsapi.org/v2/top-headlines?country=us&apiKey=94b814eea3be4ffb8cdad8ea3d0d64eb

//    @GET("top-headlines")
//     Call<Article> getAllNews(@Query("country") String search, @Query("&apiKey") String searchapikey);

//    @GET("&apiKey")
//   Call<Article> getmRetrofitNews(@Query("&apiKey")String searchapikey);

//    @GET("/maps/api/geocode/json?address={zipcode}&sensor=false")
//    void getPositionByZip(@Path("zipcode") int zipcode, Callback<String> cb);


       @GET("top-headlines?country=us&apiKey=94b814eea3be4ffb8cdad8ea3d0d64eb")
       Call<MainBranch> getAllNews();

     //  @GET("top-headlines")
   //    Call<ArrayList<MainBranch>> getAllNews(@Query("country") String search, @Query("apiKey") String searchapikey);

}
