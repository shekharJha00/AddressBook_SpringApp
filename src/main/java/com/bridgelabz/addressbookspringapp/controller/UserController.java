package com.bridgelabz.addressbookspringapp.controller;

import com.bridgelabz.addressbookspringapp.Dto.ResponseDto;
import com.bridgelabz.addressbookspringapp.Dto.UserRegistrationDto;
import com.bridgelabz.addressbookspringapp.model.UserData;
import com.bridgelabz.addressbookspringapp.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService userService;


    @PostMapping("/register")
    public ResponseEntity<ResponseDto> registerAccount(@RequestBody UserRegistrationDto userRegistrationDto) {
        UserData userData = null;
        userData = userService.createUserRegistration(userRegistrationDto);
        ResponseDto responseDto = new ResponseDto("User has been registered", userData);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }


    @GetMapping("/login")
    public ResponseEntity<ResponseDto> loginAccount(@RequestParam String userName, @RequestParam String password) {
        UserData userData = null;
        userData = userService.loginAccount(userName, password);
        ResponseDto responseDTO = new ResponseDto("Account Successfully Logged In", userData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}