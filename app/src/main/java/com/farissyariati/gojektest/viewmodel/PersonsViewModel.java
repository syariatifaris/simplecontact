package com.farissyariati.gojektest.viewmodel;

import android.content.Context;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.support.annotation.NonNull;
import android.view.View;

import com.farissyariati.gojektest.PersonApplication;
import com.farissyariati.gojektest.R;
import com.farissyariati.gojektest.data.factory.PersonFactory;
import com.farissyariati.gojektest.data.response.PersonResponse;
import com.farissyariati.gojektest.data.service.PersonService;
import com.farissyariati.gojektest.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Person View Model
 */
public class PersonsViewModel extends Observable {
    public ObservableInt personProgressState;
    public ObservableInt personRecycleViewState;
    public ObservableInt personLabelState;
    public ObservableField<String> personMessageLabel;

    private List<Person> persons;
    private Context context;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public PersonsViewModel(@NonNull Context context) {
        this.context = context;
        persons = new ArrayList<>();
        personProgressState = new ObservableInt(View.GONE);
        personRecycleViewState = new ObservableInt(View.GONE);
        personLabelState = new ObservableInt(View.VISIBLE);
        personMessageLabel = new ObservableField<>(context.getString(R.string.person_message_loading));
    }

    public void onClickLoad(View view) {
        initializeViews();
        fetchPersons();
    }

    public void initializeViews() {
        personLabelState.set(View.GONE);
        personRecycleViewState.set(View.GONE);
        personProgressState.set(View.VISIBLE);
    }

    private void fetchPersons() {
        PersonApplication personApplication = PersonApplication.create(context);
        PersonService personService = personApplication.getPersonService();

        Disposable disposable = personService.fetchPersons()
                .subscribeOn(personApplication.subscribeScheduler())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<PersonResponse>() {
                    @Override
                    public void accept(PersonResponse personResponse) throws Exception {
                        updatePersonsData(personResponse.getPersons());
                        personProgressState.set(View.GONE);
                        personLabelState.set(View.GONE);
                        personRecycleViewState.set(View.VISIBLE);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        personMessageLabel.set("An error occurred");
                        personProgressState.set(View.GONE);
                        personLabelState.set(View.VISIBLE);
                        personRecycleViewState.set(View.GONE);
                    }
                });

        compositeDisposable.add(disposable);
    }

    private void updatePersonsData(List<Person> persons){
        this.persons = new ArrayList<>();
        this.persons.addAll(persons);
        setChanged();
        notifyObservers();
    }

    public List<Person> getPersons() {
        return persons;
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
}
