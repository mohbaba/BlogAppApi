package com.mohbaba.api.dto.requests;

import lombok.Data;

@Data
public class CommentRequest {
    private String postId;
    private String commenterUsername;
    private String comment;
}
