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

    @Autowired
    Utility addressBookUtility;

    @Override
    public String getWelcomeMessage() {
        return "Welcome to Address Book Application";
    }

    @Override
    public List<ContactData> getAddressBookData() {
        return addressBookRepository.findAll();
    }


    @Override
    public String createContactData(ContactDto contactDto) {
        ContactData contactData = new ContactData(contactDto);
        addressBookRepository.save(contactData);
        String token = addressBookUtility.createToken(contactData.getContactId());

        return token;
    }


    @Override
    public ContactData updateContactData(String token, ContactDto contactDto) {
        int contactId = addressBookUtility.decodeJWT(token);
        ContactData contactData = addressBookRepository.findById(contactId).orElseThrow(() -> new AddressBookException("Id May Not be Existed"));
        contactData.updateContactInfo(contactDto);
        return addressBookRepository.save(contactData);
    }

    @Override
    public ContactData getContactById(String token) {
        int contactId = addressBookUtility.decodeJWT(token);
        return addressBookRepository.findById(contactId).orElseThrow(() -> new AddressBookException("Id not available"));
    }


    @Override
    public void deleteContactById(String token) {

        int contactId = addressBookUtility.decodeJWT(token);
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
