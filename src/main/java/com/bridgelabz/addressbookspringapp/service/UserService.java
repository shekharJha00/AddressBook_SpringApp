package com.bridgelabz.addressbookspringapp.service;

import com.bridgelabz.addressbookspringapp.Dto.UserLoginDto;
import com.bridgelabz.addressbookspringapp.Dto.UserRegistrationDto;
import com.bridgelabz.addressbookspringapp.mailSender.MailSender;
import com.bridgelabz.addressbookspringapp.model.UserData;
import com.bridgelabz.addressbookspringapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserService implements IUserService{
    @Autowired
    UserRepository userRepository;
    @Autowired
    Utility addressBookUtility;
    @Autowired
    MailSender mailSender;
    public String createUserRegistration(UserRegistrationDto userRegistrationDto) {
        UserData userData = new UserData(userRegistrationDto);
        userRepository.save(userData);
        String token = addressBookUtility.createToken(userData.getUserId());
        mailSender.sendEmail(userRegistrationDto.getUserEmail(),"Registration Succesful","Account Created with "+userData);
        return token;
    }

    @Override
    public Optional<UserData> loginAccount(UserLoginDto userLoginDto) {
        Optional<UserData> userData = userRepository.checkLogin(userLoginDto.getUserName(), userLoginDto.getPassword());
        if(userData.isPresent()){
            return userData;
        }
        else
            return null;
    }}