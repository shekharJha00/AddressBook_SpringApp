package com.bridgelabz.addressbookspringapp.Dto;


import lombok.Data;
import javax.validation.constraints.*;


@Data
public class ContactDto {

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "First name Invalid")
    @NotBlank(message = "Should Not be Empty")
    private String firstName;

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Last name Invalid")
    @NotBlank(message = "Should Not be Empty")
    private String lastName;

    @NotBlank(message = "Should Not be Empty")
    private String address;

    @NotBlank(message = "Should Not be Empty")
    private String city;
    @NotBlank(message = "Should Not be Empty")
    private String state;

    @Pattern(regexp = "^[0-9]{6}$", message = "PIN-CODE Invalid")
    @NotBlank(message = "Should Not be Empty")
    private String pin;

    @Pattern(regexp = "^[0-9]{1,2} [0-9]{10}$", message = "Phone Number Invalid")
    @NotBlank(message = "Should Not be Empty")
    private String phoneNo;

    @Email(message = "Email Invalid")
    @NotBlank(message = "Should Not be Empty")
    private String email;
}
