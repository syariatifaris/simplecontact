package com.farissyariati.gojektest.data.factory;


import com.farissyariati.gojektest.data.service.PersonService;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Person Service Factory
 */
public class PersonFactory {
    private final static String BASE_URL = "http://52.79.73.18/data/";
    public final static String RANDOM_USER_URL = "random-users.json";

    public static PersonService create(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit.create(PersonService.class);
    }
}
