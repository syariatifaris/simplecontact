package com.farissyariati.gojektest.viewmodel;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.ObservableInt;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.farissyariati.gojektest.PersonApplication;
import com.farissyariati.gojektest.data.response.GroupedContactsResponse;
import com.farissyariati.gojektest.data.service.ContactService;
import com.farissyariati.gojektest.model.Contact;
import com.farissyariati.gojektest.util.TypefaceUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Observable;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class ContactsViewModel extends Observable {

    public ObservableInt contactProgressState;
    public ObservableInt scrollLayoutState;

    private List<Contact> favouriteContacts;
    private List<Contact> sortedContacts;

    private Context context;

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public ContactsViewModel(@NonNull Context context) {
        this.context = context;
        favouriteContacts = Collections.emptyList();
        sortedContacts = Collections.emptyList();

        contactProgressState = new ObservableInt(View.VISIBLE);
        scrollLayoutState = new ObservableInt(View.GONE);

        fetchGroupedContacts();
    }

    private void fetchGroupedContacts() {
        PersonApplication personApplication = PersonApplication.create(context);
        ContactService contactService = personApplication.getContactService();

        Disposable disposable = contactService.fetchGroupedContacts()
                .subscribeOn(personApplication.subscribeScheduler())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<GroupedContactsResponse>() {
                    @Override
                    public void accept(GroupedContactsResponse groupedContactsResponse) throws Exception {
                        updateFavouriteContact(groupedContactsResponse.getFavouriteContacts());
                        updateSortedContact(groupedContactsResponse.getSortedContacts());
                        scrollLayoutState.set(View.VISIBLE);
                        contactProgressState.set(View.GONE);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        System.out.print("Here");
                    }
                });

        compositeDisposable.add(disposable);
    }

    private void updateFavouriteContact(List<Contact> favouriteContacts){
        this.favouriteContacts = new ArrayList<>();
        this.favouriteContacts.addAll(favouriteContacts);
        setChanged();
        notifyObservers();
    }

    private void updateSortedContact(List<Contact> sortedContacts){
        this.sortedContacts = new ArrayList<>();
        this.sortedContacts.addAll(sortedContacts);
        setChanged();
        notifyObservers();
    }

    @BindingAdapter(value = {"typeface"})
    public static void setMaterialTypeface(TextView textView, Context context){
        textView.setTypeface(TypefaceUtil.getMaterialTyeFace(context));
    }

    private void unSubscribeFromObservable(){
        if(compositeDisposable != null && !compositeDisposable.isDisposed()){
            compositeDisposable.dispose();
        }
    }

    public void reset(){
        unSubscribeFromObservable();
        compositeDisposable = null;
        context = null;
    }

    public Context getContext(){
        return context;
    }

    public List<Contact> getFavouriteContacts() {
        return favouriteContacts;
    }

    public List<Contact> getSortedContacts() {
        return sortedContacts;
    }
}
