package com.bridgelabz.addressbookspringapp.model;

import com.bridgelabz.addressbookspringapp.Dto.ContactDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ContactData {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private int contactId;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String pin;
    private String phoneNo;
    private String email;

    public ContactData(ContactDto contactDto){
        this.firstName = contactDto.getFirstName();
        this.lastName = contactDto.getLastName();
        this.address = contactDto.getAddress();
        this.city = contactDto.getCity();
        this.state = contactDto.getState();
        this.pin = contactDto.getPin();
        this.phoneNo = contactDto.getPhoneNo();
        this.email = contactDto.getEmail();
    }
    public void updateContactInfo(ContactDto contactDTO) {
        this.firstName = contactDTO.getFirstName();
        this.lastName = contactDTO.getLastName();
        this.address = contactDTO.getAddress();
        this.city = contactDTO.getCity();
        this.state = contactDTO.getState();
        this.pin = contactDTO.getPin();
        this.phoneNo = contactDTO.getPhoneNo();
        this.email = contactDTO.getEmail();
    }
}
