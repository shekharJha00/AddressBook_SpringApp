package com.bridgelabz.addressbookspringapp.service;

import com.bridgelabz.addressbookspringapp.Dto.ContactDto;
import com.bridgelabz.addressbookspringapp.model.ContactData;

import java.util.List;

public interface IAddressBookService {
    String getWelcomeMessage();
     List<ContactData> getAddressBookData();

    String createContactData(ContactDto contactDto);

    ContactData updateContactData(String token, ContactDto contactDto);

    ContactData getContactById(String token);

    void deleteContactById(String token);

    List<ContactData> sortContactsByCity();

    List<ContactData> sortContactsByState();
}
