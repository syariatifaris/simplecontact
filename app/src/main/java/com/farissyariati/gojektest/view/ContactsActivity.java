package com.farissyariati.gojektest.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.farissyariati.gojektest.R;
import com.farissyariati.gojektest.databinding.ActivityContactsBinding;
import com.farissyariati.gojektest.view.adapter.ContactAdapter;
import com.farissyariati.gojektest.viewmodel.ContactsViewModel;

import java.util.Observable;
import java.util.Observer;

public class ContactsActivity extends BaseActivity implements Observer{

    private ActivityContactsBinding activityContactsBinding;
    private ContactsViewModel contactsViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDataBinding();
        setupFavouriteContactsView(activityContactsBinding.listFavoriteContact);
        setupSortedContactsView(activityContactsBinding.listAllContact);
        setupObserver(contactsViewModel);
    }

    private void initDataBinding(){
        activityContactsBinding = DataBindingUtil.setContentView(this, R.layout.activity_contacts);
        contactsViewModel = new ContactsViewModel(this);
        activityContactsBinding.setContactsViewModel(contactsViewModel);
    }

    private void setupSortedContactsView(RecyclerView sortedContactRecyclerView){
        ContactAdapter sortedContactAdapter = new ContactAdapter();
        sortedContactRecyclerView.setAdapter(sortedContactAdapter);
        sortedContactRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setupFavouriteContactsView(RecyclerView favouriteRecyclerView){
        ContactAdapter favouriteContactAdapter = new ContactAdapter();
        favouriteRecyclerView.setAdapter(favouriteContactAdapter);
        favouriteRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void setupObserver(Observable observable) {
        observable.addObserver(this);
    }

    @Override
    public void update(Observable observable, Object data) {
        if(observable instanceof ContactsViewModel){
            ContactAdapter sortedContactsAdapter = (ContactAdapter) activityContactsBinding.listAllContact.getAdapter();
            ContactAdapter favouriteContactsAdapter = (ContactAdapter) activityContactsBinding.listFavoriteContact.getAdapter();
            ContactsViewModel contactsViewModel = (ContactsViewModel) observable;
            sortedContactsAdapter.setContacts(contactsViewModel.getSortedContacts());
            favouriteContactsAdapter.setContacts(contactsViewModel.getFavouriteContacts());
        }
    }
}
