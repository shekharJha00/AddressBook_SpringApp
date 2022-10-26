package com.bridgelabz.addressbookspringapp.controller;

import com.bridgelabz.addressbookspringapp.Dto.ResponseDto;
import com.bridgelabz.addressbookspringapp.Dto.UserLoginDto;
import com.bridgelabz.addressbookspringapp.Dto.UserRegistrationDto;
import com.bridgelabz.addressbookspringapp.model.UserData;
import com.bridgelabz.addressbookspringapp.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService userService;


    @PostMapping("/register")
    public ResponseEntity<ResponseDto> registerAccount(@RequestBody UserRegistrationDto userRegistrationDto){
        String token = userService.createUserRegistration(userRegistrationDto);
        ResponseDto responseDTO = new ResponseDto("User has been registered",token);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }



    @GetMapping("/login")
    public ResponseEntity<ResponseDto> loginAccount(@RequestBody UserLoginDto userLoginDto){
        Optional<UserData> userData = null;
        userData = userService.loginAccount(userLoginDto);
        ResponseDto responseDTO = new ResponseDto("Account Successfully Logged In",userData);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }
}