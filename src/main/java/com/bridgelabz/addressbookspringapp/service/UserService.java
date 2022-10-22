package com.bridgelabz.addressbookspringapp.service;

import com.bridgelabz.addressbookspringapp.Dto.UserRegistrationDto;
import com.bridgelabz.addressbookspringapp.model.UserData;
import com.bridgelabz.addressbookspringapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    UserRepository userRepository;

    public UserData createUserRegistration(UserRegistrationDto userRegistrationDTO) {
        UserData userData = null;
        userData = new UserData(userRegistrationDTO);
        return userRepository.save(userData);
    }

    @Override
    public UserData loginAccount(String userName, String password) {
        return userRepository.checkLogin(userName, password);
    }
}