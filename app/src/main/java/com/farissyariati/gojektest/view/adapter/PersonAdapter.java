package com.farissyariati.gojektest.view.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.farissyariati.gojektest.R;
import com.farissyariati.gojektest.databinding.ItemPersonBinding;
import com.farissyariati.gojektest.model.Person;
import com.farissyariati.gojektest.viewmodel.PersonViewModel;

import java.util.Collections;
import java.util.List;

/**
 * Person Adapter
 */
public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonAdapterViewHolder>{

    private List<Person> persons;

    public PersonAdapter(){
        this.persons = Collections.emptyList();
    }

    @Override
    public PersonAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemPersonBinding itemPersonBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_person, parent, false);
        return new PersonAdapterViewHolder(itemPersonBinding);
    }

    @Override
    public void onBindViewHolder(PersonAdapterViewHolder holder, int position) {
        holder.bindPerson(persons.get(position));
    }

    @Override
    public int getItemCount() {
        return persons.size();
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
        notifyDataSetChanged();
    }

    public static class PersonAdapterViewHolder extends RecyclerView.ViewHolder{
        ItemPersonBinding itemPersonBinding;

        public PersonAdapterViewHolder(ItemPersonBinding itemPersonBinding){
            super(itemPersonBinding.itemPerson);
            this.itemPersonBinding = itemPersonBinding;
        }

        void bindPerson(Person person){
            if(itemPersonBinding.getPersonViewModel() == null){
                itemPersonBinding.setPersonViewModel(new PersonViewModel(person, itemView.getContext()));
            }else{
                itemPersonBinding.getPersonViewModel().setPerson(person);
            }
        }
    }
}
