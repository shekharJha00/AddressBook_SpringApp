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

    @GetMapping(value = {"/", "/get"})
    public ResponseEntity<ResponseDto> getEmployeePayrollData() {
        List<ContactData> contactDataList = null;
        contactDataList = addressBookService.getAddressBookData();
        ResponseDto respDTO = new ResponseDto("Get Call Successful", contactDataList);
        return new ResponseEntity<ResponseDto>(respDTO, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseDto> addContact(@Valid @RequestBody ContactDto contactDto) {
        String token = addressBookService.createContactData(contactDto);
        ResponseDto responseDto = new ResponseDto("Contact Data Created SuccessFully", token);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.CREATED);
    }


    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateData(@RequestHeader String token, @Valid @RequestBody ContactDto contactDto) {
        ContactData contactData = null;
        contactData = addressBookService.updateContactData(token, contactDto);
        ResponseDto responseDTO = new ResponseDto("Updated the Contact Information for this ID", contactData);
        return new ResponseEntity<ResponseDto>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<ResponseDto> getContactById(@RequestHeader String token) {
        ContactData contactData = null;
        contactData = addressBookService.getContactById(token);
        ResponseDto responseDto = new ResponseDto("Got the Contact Information for this ID", contactData);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }


    @DeleteMapping("delete")
    public void deleteContactById(@RequestHeader String token) {
        addressBookService.deleteContactById(token);
    }


    @GetMapping("/sortByCity")
    public ResponseEntity<ResponseDto> sortByCity() {
        List<ContactData> contactList = null;
        contactList = addressBookService.sortContactsByCity();
        ResponseDto responseDto = new ResponseDto("Sorted Contacts Details", contactList);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }


    @GetMapping("/sortByState")
    public ResponseEntity<ResponseDto> sortByState() {
        List<ContactData> contactList = null;
        contactList = addressBookService.sortContactsByState();
        ResponseDto responseDTO = new ResponseDto("Sorted Contacts Details", contactList);
        return new ResponseEntity<ResponseDto>(responseDTO, HttpStatus.OK);
    }
}
