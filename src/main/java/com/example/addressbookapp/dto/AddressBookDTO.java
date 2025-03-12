package com.example.addressbookapp.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressBookDTO {

    private Long id;
    private String fullName;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String phoneNumber;
}
