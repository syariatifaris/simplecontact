package com.farissyariati.gojektest.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * The Person
 */
public class Person implements Serializable{
    @SerializedName("id")
    public int id;

    @SerializedName("first_name")
    public String firstName;

    @SerializedName("last_name")
    public String lastName;

    @SerializedName("cell")
    public String phoneNumber;

    @SerializedName("email")
    public String emailAddress;

    @SerializedName("picture")
    public String picture;

    public String fullName;
}
