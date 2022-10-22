package com.bridgelabz.addressbookspringapp.service;

import com.bridgelabz.addressbookspringapp.Dto.ContactDto;
import com.bridgelabz.addressbookspringapp.exception.AddressBookException;
import com.bridgelabz.addressbookspringapp.model.ContactData;
import com.bridgelabz.addressbookspringapp.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressBookService implements IAddressBookService {

    @Autowired
    AddressBookRepository addressBookRepository;

    @Override
    public String getWelcomeMessage() {
        return "Welcome to Address Book Application";
    }

    @Override
    public ContactData createContactData(ContactDto contactDTO) {
        ContactData contactData = null;
        contactData = new ContactData(contactDTO);
        return addressBookRepository.save(contactData);
    }

    @Override
    public ContactData updateContactData(int contactId, ContactDto contactDTO) {
        ContactData contactData = addressBookRepository.findById(contactId).orElseThrow(() -> new AddressBookException("Id May Not be Existed"));
        contactData.updateContactInfo(contactDTO);
        return addressBookRepository.save(contactData);
    }

    @Override
    public ContactData getContactById(int contactId) {

        return addressBookRepository.findById(contactId).orElseThrow(() -> new AddressBookException("Id not available"));
    }

    @Override
    public void deleteContactById(int contactId) {
        addressBookRepository.deleteById(contactId);
    }
    @Override
    public List<ContactData> sortContactsByCity() {
        return addressBookRepository.sortByCity();
    }

    @Override
    public List<ContactData> sortContactsByState() {
        return addressBookRepository.sortByState();
    }
}
