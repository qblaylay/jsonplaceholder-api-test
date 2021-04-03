package com.jsonplaceholder.model;

import lombok.Getter;

@Getter
public class User {

    private Integer id;
    private String name;
    private String username;
    private String email;
    private Address address;
    private String phone;
    private String website;
    private Company company;

}
