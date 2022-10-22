package com.bridgelabz.addressbookspringapp.service;

import com.bridgelabz.addressbookspringapp.Dto.ContactDto;
import com.bridgelabz.addressbookspringapp.model.ContactData;

import java.util.List;

public interface IAddressBookService {
    String getWelcomeMessage();
   List<ContactData> getAddressBookData();

    ContactData createContactData(ContactDto contactDTO);

    ContactData updateContactData(int contactId, ContactDto contactDTO);

    ContactData getContactById(int contactId);

    void deleteContactById(int contactId);

    List<ContactData> sortContactsByCity();

    List<ContactData> sortContactsByState();
}
