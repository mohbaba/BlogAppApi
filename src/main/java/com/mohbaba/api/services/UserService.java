package com.mohbaba.api.services;

import com.mohbaba.api.data.models.Post;
import com.mohbaba.api.dto.requests.PostRequest;
import com.mohbaba.api.dto.requests.RegisterUserRequest;
import com.mohbaba.api.dto.requests.ViewRequest;
import com.mohbaba.api.dto.responses.RegisterUserResponse;

public interface UserService {
    RegisterUserResponse registerUser(RegisterUserRequest registerUserRequest);

    long countNumberOfUsers();

    Post  post(PostRequest postRequest);

    long getNumberOfPosts();
    int getNumberOfPosts(String username);

    long getTotalNumberOfViews();

    long getNumberOfViews(Post post);

    void view(ViewRequest viewRequest);
}
