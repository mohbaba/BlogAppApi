package com.mohbaba.api.dto.responses;


import lombok.Data;

@Data
public class RegisterUserResponse {
    private String id;
    private String firstName;
    private String lastName;
    private String username;
}
