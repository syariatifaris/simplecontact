package com.farissyariati.gojektest.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * The Base Model
 */
public class BaseModel implements Serializable{
    @SerializedName("id")
    public int id;
}
