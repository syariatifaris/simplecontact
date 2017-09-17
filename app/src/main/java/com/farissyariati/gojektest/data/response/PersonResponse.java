package com.farissyariati.gojektest.data.response;

import com.farissyariati.gojektest.model.Person;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Person Response
 */
public class PersonResponse {

    @SerializedName("results")
    private List<Person> persons;

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
}
