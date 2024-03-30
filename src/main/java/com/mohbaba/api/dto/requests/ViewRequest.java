package com.mohbaba.api.dto.requests;

import lombok.Data;

@Data
public class ViewRequest {
    private String postId;
    private String viewerUsername;
}
