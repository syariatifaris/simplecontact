package com.farissyariati.gojektest.data.service;

import com.farissyariati.gojektest.data.factory.PersonFactory;
import com.farissyariati.gojektest.data.response.PersonResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Person Service Invoker
 */
public interface PersonService {
    @GET(PersonFactory.RANDOM_USER_URL)
    Observable<PersonResponse> fetchPersons();
}
