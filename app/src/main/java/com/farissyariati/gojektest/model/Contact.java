package com.farissyariati.gojektest.model;

import com.google.gson.annotations.SerializedName;

/**
 * Contact Model
 */
public class Contact extends BaseModel{

    @SerializedName("first_name")
    public String firstName;

    @SerializedName("last_name")
    public String lastName;

    @SerializedName("email_address")
    public String emailAddress;

    @SerializedName("phone_number")
    public String phoneNumber;

    @SerializedName("profile_image")
    public String profileImage;

    public String fullName;
}
