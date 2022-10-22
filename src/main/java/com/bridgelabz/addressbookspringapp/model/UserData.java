package com.bridgelabz.addressbookspringapp.model;


import com.bridgelabz.addressbookspringapp.Dto.UserRegistrationDto;
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
public class UserData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    private String userName;
    private String userEmail;
    private String password;


    public UserData(UserRegistrationDto userRegistrationDto) {
        this.userName = userRegistrationDto.getUserName();
        this.userEmail = userRegistrationDto.getUserEmail();
        this.password = userRegistrationDto.getPassword();
    }
}
