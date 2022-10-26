package com.bridgelabz.addressbookspringapp.service;

import com.bridgelabz.addressbookspringapp.Dto.UserLoginDto;
import com.bridgelabz.addressbookspringapp.Dto.UserRegistrationDto;
import com.bridgelabz.addressbookspringapp.model.UserData;

import java.util.Optional;

public interface IUserService {

    String createUserRegistration(UserRegistrationDto userRegistrationDto);


    Optional<UserData> loginAccount(UserLoginDto userLoginDto);
}