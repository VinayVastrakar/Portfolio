package com.vinay.portfolio_backend.Dto;


import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ContactDTO {
    private Long contactId;
    private String contactType;
    private String contactValue;

    // Getters and setters
}
