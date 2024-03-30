package com.mohbaba.api.utils;

import com.mohbaba.api.data.models.Post;
import com.mohbaba.api.data.models.User;
import com.mohbaba.api.dto.requests.PostRequest;
import com.mohbaba.api.dto.requests.RegisterUserRequest;
import com.mohbaba.api.dto.responses.RegisterUserResponse;

public class Mapper {
    public static User map(RegisterUserRequest registerUserRequest) {
        User user = new User();
        user.setFirstName(registerUserRequest.getFirstName());
        user.setLastName(registerUserRequest.getLastName());
        user.setUsername(registerUserRequest.getUsername());
        return user;
    }

    public static RegisterUserResponse map(User user) {
        RegisterUserResponse response = new RegisterUserResponse();
        response.setId(user.getId());
        response.setFirstName(user.getFirstName());
        response.setLastName(user.getLastName());
        response.setUsername(user.getUsername());
        return response;
    }

    public static Post map(PostRequest postRequest){
        Post post = new Post();
        post.setContent(postRequest.getContent());
        post.setTitle(postRequest.getTitle());
        return post;
    }
}
