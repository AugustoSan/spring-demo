package com.apitest.demo.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Establishment")
public class EstablishmentModel {
    @Id
    private String id;
    private String name;
    private String description;
    private String token;
    private String address;
    private String phone;
    private String logo;
    private String email;
}
