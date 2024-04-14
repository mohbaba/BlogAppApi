package com.mohbaba.api.services;

import com.mohbaba.api.data.models.Post;
import com.mohbaba.api.data.models.User;
import com.mohbaba.api.dto.requests.CommentRequest;
import com.mohbaba.api.dto.requests.PostRequest;
import com.mohbaba.api.dto.requests.RegisterUserRequest;
import com.mohbaba.api.dto.requests.ViewRequest;
import com.mohbaba.api.dto.responses.RegisterUserResponse;

import java.util.List;

public interface UserService {
    RegisterUserResponse registerUser(RegisterUserRequest registerUserRequest);

    long countNumberOfUsers();

    void  post(PostRequest postRequest);

    long getNumberOfPosts();
    int getNumberOfPosts(String username);

    long getTotalNumberOfViews();

    long getNumberOfViews(ViewRequest post);

    void view(ViewRequest viewRequest);

    List<Post> getAllPosts();

    void comment(CommentRequest commentRequest);

    long getTotalNumberOfComments();

    User findUser(String username);
}
