package com.jsonplaceholder.model;

import lombok.Getter;

@Getter
public class Address {

    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geo geo;
}