package com.farissyariati.gojektest.data.response;


import com.farissyariati.gojektest.model.Contact;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GroupedContactsResponse {
    @SerializedName("favourite_contacts")
    private List<Contact> favouriteContacts;

    @SerializedName("sorted_contacts")
    private List<Contact> sortedContacts;

    public List<Contact> getFavouriteContacts() {
        return favouriteContacts;
    }

    public void setFavouriteContacts(List<Contact> favouriteContacts) {
        this.favouriteContacts = favouriteContacts;
    }

    public List<Contact> getSortedContacts() {
        return sortedContacts;
    }

    public void setSortedContacts(List<Contact> sortedContacts) {
        this.sortedContacts = sortedContacts;
    }
}
