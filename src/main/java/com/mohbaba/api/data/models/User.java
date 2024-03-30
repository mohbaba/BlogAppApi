package com.mohbaba.api.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document
public class User {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String username;
    @DBRef
    private List<Post> posts = new ArrayList<>();
}
