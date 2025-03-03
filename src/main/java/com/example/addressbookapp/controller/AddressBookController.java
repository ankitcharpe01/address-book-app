package com.example.addressbookapp.controller;

import com.example.addressbookapp.dto.AddressBookDTO;
import com.example.addressbookapp.model.AddressBook;
import com.example.addressbookapp.service.AddressBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/addressbook")
public class AddressBookController {

    private final AddressBookService addressBookService;

    public AddressBookController(AddressBookService addressBookService) {
        this.addressBookService = addressBookService;
    }

    // GET All Contacts
    @GetMapping
    public ResponseEntity<List<AddressBook>> getAllContacts() {
        log.info("GET /addressbook - Fetching all contacts");
        return ResponseEntity.ok(addressBookService.getAllContacts());
    }

    // GET Contact By ID
    @GetMapping("/{id}")
    public ResponseEntity<AddressBook> getContactById(@PathVariable Long id) {
        log.info("GET /addressbook/{} - Fetching contact", id);
        AddressBook contact = addressBookService.getContactById(id);
        if (contact != null) {
            log.info("Contact found: {}", contact);
            return ResponseEntity.ok(contact);
        } else {
            log.warn("Contact with ID {} not found", id);
            return ResponseEntity.notFound().build();
        }
    }

    // POST Add New Contact
    @PostMapping
    public ResponseEntity<AddressBook> addContact(@RequestBody AddressBookDTO dto) {
        log.info("POST /addressbook - Adding new contact: {}", dto);
        AddressBook newContact = addressBookService.addContact(dto);
        log.info("New contact added successfully: {}", newContact);
        return ResponseEntity.ok(newContact);
    }

    // PUT Update Contact By ID
    @PutMapping("/{id}")
    public ResponseEntity<AddressBook> updateContact(@PathVariable Long id, @RequestBody AddressBookDTO dto) {
        log.info("PUT /addressbook/{} - Updating contact: {}", id, dto);
        AddressBook updatedContact = addressBookService.updateContact(id, dto);
        if (updatedContact != null) {
            log.info("Contact updated successfully: {}", updatedContact);
            return ResponseEntity.ok(updatedContact);
        } else {
            log.warn("Update failed - Contact with ID {} not found", id);
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE Contact By ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable Long id) {
        boolean deleted = addressBookService.deleteContact(id);
        if (deleted) {
            log.info("Contact with ID {} deleted successfully", id);
            return ResponseEntity.ok("Deleted Successfully");
        } else {
            log.warn("Delete failed - Contact with ID {} not found", id);
            return ResponseEntity.notFound().build();
        }
    }
}
