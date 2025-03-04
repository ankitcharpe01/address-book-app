package com.example.addressbookapp.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AddressBookDTO {
    private String name;
    private String phone;
    private String email;
}
