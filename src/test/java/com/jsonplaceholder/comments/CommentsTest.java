package com.jsonplaceholder.comments;

import com.jsonplaceholder.controller.CommentController;
import com.jsonplaceholder.controller.PostController;
import com.jsonplaceholder.controller.UserController;
import com.jsonplaceholder.model.Comment;
import com.jsonplaceholder.model.Post;
import com.jsonplaceholder.model.User;
import com.jsonplaceholder.util.EmailUtil;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CommentsTest {

    public UserController userController;
    public PostController postController;
    public CommentController commentController;


    @BeforeClass
    public void setup() {

        userController = new UserController();
        commentController = new CommentController();
        postController = new PostController();
    }


    @Test(description = "Retrieve Comments")
    public void When_Retrieve_Commands_Then_All_Comments_Listed() {

        Comment[] comments = commentController.retrieveComments();

        assertThat(comments).hasSize(500);

    }

    @Test(description = "Retrieve Comments With Specific PostId")
    public void Given_PostId_When_Retrieve_Comments_Then_Comments_PerPost_Listed() {

        String username = "Delphine";

        User[] users = userController.retrieveUsersByUsername(username);
        Integer userId = users[0].getId();

        Post[] posts = postController.retrievePostsByUserId(userId);

        for(int i=0; i< posts.length; i++){
            Integer postId = posts[i].getId();
            Comment[] comments = commentController.retrieveCommentsByPostId(postId);
            assertThat(comments).hasSize(5);


            for(int j=0;j<comments.length; j++){
                assertThat(EmailUtil.isValidEmail(comments[j].getEmail())).isTrue();
                assertThat(comments[j].getPostId()).isEqualTo(postId);

            }

        }


    }
}
