package com.bridgelabz.addressbookspringapp.service;

import com.bridgelabz.addressbookspringapp.Dto.UserRegistrationDto;
import com.bridgelabz.addressbookspringapp.model.UserData;

public interface IUserService {

    UserData createUserRegistration(UserRegistrationDto userRegistrationDTO);


    UserData loginAccount(String userName, String password);
}