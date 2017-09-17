package com.farissyariati.gojektest.data.factory;


import com.farissyariati.gojektest.data.service.ContactService;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Contact Service Factory
 */
public class ContactFactory {
    private final static String BASE_URL = "http://52.79.73.18/data/";
    public final static String GET_GROUPED_CONTACTS = "random-contacts.json";

    public static ContactService create(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit.create(ContactService.class);
    }
}
