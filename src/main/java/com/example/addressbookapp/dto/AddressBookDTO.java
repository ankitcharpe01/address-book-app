package com.example.addressbookapp.dto;

import lombok.Data;

@Data
public class AddressBookDTO {
    private String name;
    private String phone;
    private String email;

    public AddressBookDTO(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

}

