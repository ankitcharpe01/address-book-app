package com.example.addressbookapp.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "address_book")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AddressBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String phone;

    private String email;
}
