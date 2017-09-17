package com.farissyariati.gojektest;

import android.app.Application;
import android.content.Context;

import com.farissyariati.gojektest.data.factory.ContactFactory;
import com.farissyariati.gojektest.data.service.ContactService;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

/**
 * Person Application
 */
public class PersonApplication extends Application{

    private ContactService contactService;

    private Scheduler scheduler;

    public static PersonApplication create(Context context){
        return PersonApplication.get(context);
    }

    public ContactService getContactService(){
        if(contactService == null){
            contactService = ContactFactory.create();
        }

        return contactService;
    }

    public Scheduler subscribeScheduler(){
        if(scheduler == null){
            scheduler = Schedulers.io();
        }

        return scheduler;
    }

    private static PersonApplication get(Context context){
        return (PersonApplication)context.getApplicationContext();
    }

    public void setScheduler(Scheduler scheduler) {
        this.scheduler = scheduler;
    }
}
