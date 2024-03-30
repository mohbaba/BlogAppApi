package com.mohbaba.api.dto.requests;

import lombok.Data;

@Data
public class RegisterUserRequest {
    private String firstName;
    private String lastName;
    private String username;
}
