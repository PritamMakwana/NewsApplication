package com.example.newsapplication;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewsRetrofit {

    private static Retrofit mRetrofit;
    private static String BASH_URL ="https://newsapi.org/v2/";

    public static Retrofit getmRetrofitNews() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
                .connectTimeout(4000, TimeUnit.SECONDS)
                .readTimeout(5000, TimeUnit.SECONDS)
                .writeTimeout(5000, TimeUnit.SECONDS);


        if (mRetrofit == null) {
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(BASH_URL)
                    .client(httpClient.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return mRetrofit;
    }
}
