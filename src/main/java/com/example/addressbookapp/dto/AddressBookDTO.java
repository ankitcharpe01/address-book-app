package com.example.addressbookapp.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AddressBookDTO {
    @NotEmpty(message = "Name cannot be Blank")
    @Pattern(regexp = "^[A-Z][a-zA-Z]{2,}(\\s[A-Z][a-zA-Z]+)*$", message = "Name must start with a capital letter and have at least 3 characters")
    private String name;

    @NotEmpty(message = "Phone number cannot be empty")
    private String phone;

    @NotEmpty(message = "Email cannot be empty")
    private String email;
}
