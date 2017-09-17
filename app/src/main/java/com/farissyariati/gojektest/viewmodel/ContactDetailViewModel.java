package com.farissyariati.gojektest.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.farissyariati.gojektest.model.Contact;
import com.farissyariati.gojektest.util.TypefaceUtil;

/**
 * Contact Detail View Model
 */
public class ContactDetailViewModel extends BaseObservable{
    private Contact contactDetail;
    private Context context;

    public ContactDetailViewModel(@NonNull Context context, Contact contactDetail){
        this.context = context;
        this.contactDetail = contactDetail;
    }

    public String getPhoneNumber(){
        return contactDetail.phoneNumber;
    }

    public String getFullName(){
        return contactDetail.firstName + " " + contactDetail.lastName;
    }

    public String getProfileImage(){
        return contactDetail.profileImage;
    }

    public String getEmailAddress(){
        return contactDetail.emailAddress;
    }

    public Context getContext(){
        return context;
    }

    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView, String url){
        Glide.with(imageView.getContext()).load(url).into(imageView);
    }

    @BindingAdapter(value = {"typeface"})
    public static void setMaterialTypeface(TextView textView, Context context){
        textView.setTypeface(TypefaceUtil.getMaterialTyeFace(context));
    }
}
