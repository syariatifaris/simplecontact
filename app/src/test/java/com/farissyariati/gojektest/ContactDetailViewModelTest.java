package com.farissyariati.gojektest;

import com.farissyariati.gojektest.model.Contact;
import com.farissyariati.gojektest.viewmodel.ContactDetailViewModel;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;
import static org.junit.Assert.*;

/**
 * Test Contact Detail View Model
 */
@RunWith(RobolectricGradleTestRunner.class) @Config(constants = BuildConfig.class, sdk = 21)
public class ContactDetailViewModelTest {
    private PersonApplication personApplication;
    private ContactDetailViewModel contactDetailViewModel;
    private Contact contact;

    @Before
    public void initViewModel(){
        personApplication = (PersonApplication) RuntimeEnvironment.application;

        contact = new Contact();
        contact.firstName = "Faris";
        contact.lastName = "Muhammad";
        contact.phoneNumber = "+6281315123964";
        contact.emailAddress = "syariati.faris@gmail.com";
        contact.profileImage = "https://randomuser.me/api/portraits/men/37.jpg";

        contactDetailViewModel = new ContactDetailViewModel(personApplication, contact);
    }

    @Test
    public void shouldGetFullName() throws Exception{
        assertEquals(contact.firstName + " " + contact.lastName, contactDetailViewModel.getFullName());
    }

    @Test
    public void shouldGetProfileImage() throws Exception{
        assertEquals(contact.profileImage, contactDetailViewModel.getProfileImage());
    }
}
