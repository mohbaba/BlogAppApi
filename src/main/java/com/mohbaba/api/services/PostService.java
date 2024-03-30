package com.mohbaba.api.services;

import com.mohbaba.api.data.models.Post;
import com.mohbaba.api.data.models.User;
import com.mohbaba.api.dto.requests.PostRequest;

import java.util.List;

public interface PostService {
    void addPost(User user, Post post);
    long getPostCount();

    Post findPost(String id);

    void save(Post post);

    Post findPostBy(String username);
}
