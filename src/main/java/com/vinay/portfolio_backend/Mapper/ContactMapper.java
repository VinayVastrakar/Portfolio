package com.vinay.portfolio_backend.Mapper;

import com.vinay.portfolio_backend.Dto.ContactDTO;
import com.vinay.portfolio_backend.Models.Contact;

public class ContactMapper {

    public static ContactDTO toDTO(Contact contact) {
        ContactDTO dto = new ContactDTO();
        dto.setContactId(contact.getContactId());
        dto.setContactType(contact.getContactType());
        dto.setContactValue(contact.getContactValue());
        return dto;
    }

    public static Contact toEntity(ContactDTO dto) {
        Contact contact = new Contact();
        contact.setContactId(dto.getContactId());
        contact.setContactType(dto.getContactType());
        contact.setContactValue(dto.getContactValue());
        return contact;
    }
}
