package com.bridgelabz.addressbookspringapp.controller;

import com.bridgelabz.addressbookspringapp.Dto.ContactDto;
import com.bridgelabz.addressbookspringapp.Dto.ResponseDto;
import com.bridgelabz.addressbookspringapp.model.ContactData;
import com.bridgelabz.addressbookspringapp.service.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/AddressBook")
public class AddressBookController {

    @Autowired
    IAddressBookService addressBookService;

    
    @GetMapping(value = {"", "/welcome"})
    public String welcomeMessage() {
        return addressBookService.getWelcomeMessage();
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseDto> AddContact(@Valid @RequestBody ContactDto contactDTO) {
        ContactData contactData = null;
        contactData = addressBookService.createContactData(contactDTO);
        ResponseDto responseDTO = new ResponseDto("Contact Data Created SuccessFully", contactData);
        return new ResponseEntity<ResponseDto>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/update/{contactId}")
    public ResponseEntity<ResponseDto> updateContact(@PathVariable int contactId, @Valid @RequestBody ContactDto contactDTO) {
        ContactData contactData = null;
        contactData = addressBookService.updateContactData(contactId, contactDTO);
        ResponseDto responseDTO = new ResponseDto("Updated the Contact Information for this ID", contactData);
        return new ResponseEntity<ResponseDto>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/get/{contactId}")
    public ResponseEntity<ResponseDto> getContactById(@PathVariable int contactId) {
        ContactData contactData = null;
        contactData = addressBookService.getContactById(contactId);
        ResponseDto responseDto = new ResponseDto("Got the Contact Information for this ID", contactData);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

    @DeleteMapping("delete/{contactId}")
    public void deleteContactById(@PathVariable int contactId) {
        addressBookService.deleteContactById(contactId);
    }

    @GetMapping("/sortByCity")
    public ResponseEntity<ResponseDto> sortByCity() {
        List<ContactData> contactList = null;
        contactList = addressBookService.sortContactsByCity();
        ResponseDto responseDTO = new ResponseDto("Sorted Contacts Details", contactList);
        return new ResponseEntity<ResponseDto>(responseDTO, HttpStatus.OK);
    }


    @GetMapping("/sortByState")
    public ResponseEntity<ResponseDto> sortByState() {
        List<ContactData> contactList = null;
        contactList = addressBookService.sortContactsByState();
        ResponseDto responseDTO = new ResponseDto("Sorted Contacts Details", contactList);
        return new ResponseEntity<ResponseDto>(responseDTO, HttpStatus.OK);
    }
}
