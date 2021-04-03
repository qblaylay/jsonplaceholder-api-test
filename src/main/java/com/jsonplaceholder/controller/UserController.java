package com.jsonplaceholder.controller;

import com.jsonplaceholder.constans.UrlConst;
import com.jsonplaceholder.model.User;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class UserController {
    public RequestSpecification requestSpec;

    public UserController() {
        requestSpec = new RequestSpecBuilder()
                .setBaseUri(UrlConst.BASE_URL)
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .build();
    }

    public User[] retrieveUsers (){

        User[] users = given(requestSpec)
                .when()
                .get(UrlConst.USERS_URL)
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .as(User[].class);
        return users;
    }

    public User[] retrieveUsersByUsername (String username){

        User[] users = given(requestSpec)
                .queryParam("username",username)
                .when()
                .get(UrlConst.USERS_URL)
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .as(User[].class);
        return users;
    }
}
