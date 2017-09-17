package com.farissyariati.gojektest.view;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.farissyariati.gojektest.R;
import com.farissyariati.gojektest.databinding.ActivityContactDetailBinding;
import com.farissyariati.gojektest.model.Contact;
import com.farissyariati.gojektest.viewmodel.ContactDetailViewModel;

public class ContactDetailActivity extends BaseActivity{
    private static final String INTENT_CONTACT = "INTENT_CONTACT";
    private ActivityContactDetailBinding activityContactDetailBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityContactDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_contact_detail);
        getContactFromIntent();
    }

    public static Intent getContactDetailIntentForLaunch(Context context, Contact contact){
        Intent intent = new Intent(context, ContactDetailActivity.class);
        intent.putExtra(INTENT_CONTACT, contact);
        return intent;
    }

    private void getContactFromIntent(){
        Contact contact = (Contact) getIntent().getSerializableExtra(INTENT_CONTACT);
        ContactDetailViewModel contactDetailViewModel = new ContactDetailViewModel(this, contact);
        activityContactDetailBinding.setContactDetailViewModel(contactDetailViewModel);
    }
}
