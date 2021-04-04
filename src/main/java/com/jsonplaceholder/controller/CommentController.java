package com.jsonplaceholder.controller;

import com.jsonplaceholder.constans.UrlConst;
import com.jsonplaceholder.model.Comment;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class CommentController {
    public RequestSpecification requestSpec;

    public CommentController() {

        requestSpec = new RequestSpecBuilder()
                .setBaseUri(UrlConst.BASE_URL)
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .addFilter(new AllureRestAssured())
                .build();
    }

    public Comment[] retrieveComments() {
        Comment[] comments = given(requestSpec)
                .when()
                .get(UrlConst.COMMENTS_URL)
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .as(Comment[].class);
        return comments;
    }


    public Comment[] retrieveCommentsByPostId(Integer postId){
        Comment[] comments = given(requestSpec)
                .queryParam("postId", postId)
                .when()
                .get(UrlConst.COMMENTS_URL)
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .as(Comment[].class);
        return comments;

    }
}
