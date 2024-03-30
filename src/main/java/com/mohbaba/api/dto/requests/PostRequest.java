package com.mohbaba.api.dto.requests;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PostRequest {
    private String username;
    private String title;
    private String content;
//    private LocalDateTime createdAt;

}
