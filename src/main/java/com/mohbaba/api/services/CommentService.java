package com.mohbaba.api.services;

import com.mohbaba.api.data.models.Post;
import com.mohbaba.api.data.models.User;
import com.mohbaba.api.dto.requests.CommentRequest;


public interface CommentService {
    Post addComment(CommentRequest commentRequest, User user);
    long count();


}
