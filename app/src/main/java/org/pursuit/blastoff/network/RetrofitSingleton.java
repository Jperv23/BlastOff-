package org.pursuit.blastoff.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitSingleton {

    private static Retrofit retrofitInstance;
    private static final String URL = "https://raw.githubusercontent.com";

    private RetrofitSingleton() {
    }

    public static Retrofit getRetrofitInstance() {
        if (retrofitInstance == null) {
            retrofitInstance = new Retrofit.Builder()
                    .baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofitInstance;
    }
}
