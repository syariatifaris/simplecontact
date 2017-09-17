package com.farissyariati.gojektest.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.farissyariati.gojektest.model.Person;

/**
 * Person View Model
 */
public class PersonViewModel extends BaseObservable {
    private Person person;
    private Context context;

    public PersonViewModel(Person person, Context context) {
        this.person = person;
        this.context = context;
    }

    public String getFullName(){
        person.fullName = person.firstName + " " + person.lastName;
        return person.fullName;
    }

    public String getPhoneNumber(){
        return person.phoneNumber;
    }

    public String getEmailAddress(){
        return person.emailAddress;
    }

    public String getProfilePicture(){
        return person.picture;
    }

    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView, String url){
        Glide.with(imageView.getContext()).load(url).into(imageView);
    }

    public void onItemClick(View view){
        Toast.makeText(this.context, person.fullName, Toast.LENGTH_LONG).show();
        person.emailAddress = "hoba@gmail.com";
    }

    public void setPerson(Person person){
        this.person = person;
        notifyChange();
    }
}
