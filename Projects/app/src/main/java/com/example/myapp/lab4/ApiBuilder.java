package com.example.myapp.lab4;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

//A Retrofit class which holds an implementation of the ApiService interface
public class ApiBuilder {
    private static ApiService apiBuilder;
    private final static String BASE_URL = "http://www.omdbapi.com";
    public final static String API_KEY = "4a2df6c1";
    static ApiService getInstance(){
        if(apiBuilder == null){
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new
                    OkHttpClient.Builder().addInterceptor(interceptor).build();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(MoshiConverterFactory.create())
                    .build();
            apiBuilder = retrofit.create(ApiService.class);
        }
        return apiBuilder;
    }
}
