package com.farissyariati.gojektest.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.Toast;

import com.farissyariati.gojektest.model.Contact;
import com.farissyariati.gojektest.util.ColorUtil;
import com.farissyariati.gojektest.view.ContactDetailActivity;
import com.farissyariati.gojektest.view.widget.CircularTextView;

/**
 * Person View Model
 */
public class ContactItemViewModel extends BaseObservable {
    private Contact contact;
    private Context context;

    public ContactItemViewModel(Contact contact, Context context) {
        this.contact = contact;
        this.context = context;
    }

    public String getFullName(){
        contact.fullName = contact.firstName + " " + contact.lastName;
        return contact.fullName;
    }

    public String getInitialLetter(){
        return Character.toString(contact.firstName.charAt(0)).toUpperCase();
    }

    public void onItemClick(View view){
        context.startActivity(ContactDetailActivity.getContactDetailIntentForLaunch(view.getContext(), contact));
    }

    public Context getContext(){
        return context;
    }

    public void setContact(Contact contact){
        this.contact = contact;
        notifyChange();
    }

    @BindingAdapter("dynamicText")
    public static void setDynamicTextBgColor(CircularTextView circularTextView, Context context){
        String colorHex = ColorUtil.getRandomMaterialColorHex("500", context);
        circularTextView.setStrokeColor(colorHex);
        circularTextView.setSolidColor(colorHex);
    }
}
