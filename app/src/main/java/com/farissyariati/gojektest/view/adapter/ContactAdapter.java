package com.farissyariati.gojektest.view.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.farissyariati.gojektest.R;
import com.farissyariati.gojektest.databinding.ItemContactBinding;
import com.farissyariati.gojektest.model.Contact;
import com.farissyariati.gojektest.viewmodel.ContactItemViewModel;

import java.util.Collections;
import java.util.List;

/**
 * Contact Adapter
 */
public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactAdapterViewHolder>{

    private List<Contact> contacts;

    public ContactAdapter(){
        this.contacts = Collections.emptyList();
    }

    @Override
    public ContactAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemContactBinding itemContactBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_contact, parent, false);
        return new ContactAdapterViewHolder(itemContactBinding);
    }

    @Override
    public void onBindViewHolder(ContactAdapterViewHolder holder, int position) {
        holder.bindContact(contacts.get(position));
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
        notifyDataSetChanged();
    }

    public static class ContactAdapterViewHolder extends RecyclerView.ViewHolder{
        ItemContactBinding itemContactBinding;

        public ContactAdapterViewHolder(ItemContactBinding itemContactBinding){
            super(itemContactBinding.itemContact);
            this.itemContactBinding = itemContactBinding;
        }

        void bindContact(Contact contact){
            if(itemContactBinding.getContactItemViewModel() == null){
                itemContactBinding.setContactItemViewModel(new ContactItemViewModel(contact, itemView.getContext()));
            }else{
                itemContactBinding.getContactItemViewModel().setContact(contact);
            }
        }
    }
}
