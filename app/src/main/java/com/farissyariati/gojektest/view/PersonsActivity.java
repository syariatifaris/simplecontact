package com.farissyariati.gojektest.view;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.farissyariati.gojektest.R;
import com.farissyariati.gojektest.databinding.ActivityPersonsBinding;
import com.farissyariati.gojektest.view.adapter.PersonAdapter;
import com.farissyariati.gojektest.viewmodel.PersonsViewModel;

import java.util.Observable;
import java.util.Observer;

public class PersonsActivity extends AppCompatActivity implements Observer{

    private ActivityPersonsBinding activityPersonsBinding;
    private PersonsViewModel personsViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDataBinding();
        setupPersonsView(activityPersonsBinding.listPeople);
        setupObserver(personsViewModel);
    }

    private void initDataBinding(){
        activityPersonsBinding = DataBindingUtil.setContentView(this, R.layout.activity_persons);
        personsViewModel = new PersonsViewModel(this);
        activityPersonsBinding.setMainViewModel(personsViewModel);
    }

    private void setupPersonsView(RecyclerView personsRecycleView){
        PersonAdapter personAdapter = new PersonAdapter();
        personsRecycleView.setAdapter(personAdapter);
        personsRecycleView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void setupObserver(Observable observable) {
        observable.addObserver(this);
    }

    @Override
    public void update(Observable observable, Object data) {
        if(observable instanceof PersonsViewModel){
            PersonAdapter personAdapter = (PersonAdapter) activityPersonsBinding.listPeople.getAdapter();
            PersonsViewModel personsViewModel = (PersonsViewModel) observable;
            personAdapter.setPersons(personsViewModel.getPersons());
        }
    }
}
