package com.farissyariati.gojektest;

import android.app.Application;
import android.content.Context;

import com.farissyariati.gojektest.data.factory.ContactFactory;
import com.farissyariati.gojektest.data.factory.PersonFactory;
import com.farissyariati.gojektest.data.service.ContactService;
import com.farissyariati.gojektest.data.service.PersonService;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

/**
 * Person Application
 */
public class PersonApplication extends Application{

    private PersonService personService;
    private ContactService contactService;

    private Scheduler scheduler;

    public static PersonApplication create(Context context){
        return PersonApplication.get(context);
    }

    public PersonService getPersonService(){
        if(personService == null){
            personService = PersonFactory.create();
        }

        return personService;
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

    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    public void setScheduler(Scheduler scheduler) {
        this.scheduler = scheduler;
    }
}
