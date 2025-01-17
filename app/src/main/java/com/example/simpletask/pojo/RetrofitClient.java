package com.example.simpletask.pojo;

import retrofit2.Retrofit;
import retrofit2.converter.jaxb.JaxbConverterFactory;

public class RetrofitClient {

    private static final String BASE_URL = "http://operation.tez-tour.com/";
    private static Retrofit retrofit;

    public static Retrofit getInstance() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(JaxbConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
