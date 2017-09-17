package com.farissyariati.gojektest.data.service;

import com.farissyariati.gojektest.data.factory.ContactFactory;
import com.farissyariati.gojektest.data.response.GroupedContactsResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Person Service Invoker
 */
public interface ContactService {
    @GET(ContactFactory.GET_GROUPED_CONTACTS)
    Observable<GroupedContactsResponse> fetchGroupedContacts();
}
