package com.mohbaba.api;

import com.mohbaba.api.data.repositories.UserRepository;
import com.mohbaba.api.dto.requests.PostRequest;
import com.mohbaba.api.dto.requests.ViewRequest;
import com.mohbaba.api.exceptions.EmptyPostException;
import com.mohbaba.api.services.UserService;
import com.mohbaba.api.exceptions.UsernameExistsException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.mohbaba.api.dto.requests.RegisterUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService   userService;
    @Autowired
    private UserRepository userRepository;

    RegisterUserRequest userRequest;


    @BeforeEach
    public void setup(){
        userRequest = new RegisterUserRequest();
        userRequest.setUsername("username");
        userRequest.setFirstName("first name");
        userRequest.setLastName("last name");
        userService.registerUser(userRequest);

    }

    @AfterEach
    public void teardown(){
        userRepository.deleteAll();
    }


    @Test
    public void userRegisters_RegisteredUsersIncreaseTest(){
        RegisterUserRequest newUserRequest = new RegisterUserRequest();
        newUserRequest.setUsername("mo");
        newUserRequest.setFirstName("first");
        newUserRequest.setLastName("last");
        var result = userService.registerUser(newUserRequest);
        assertNotNull(result);

        assertEquals(2L,userService.countNumberOfUsers());

    }


    @Test
    public void userRegistersWithPreExistingUsername_throwsExceptionTest(){
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setUsername("username");
        registerUserRequest.setFirstName("first name");
        registerUserRequest.setLastName("last name");

        assertThrows(UsernameExistsException.class,()->userService.registerUser(registerUserRequest));
    }

    @Test
    public void userMakesPost_NumberOfPostsInRepositoryIncreasesTest(){
        assertEquals(0,userService.getNumberOfPosts("username"));
        PostRequest postRequest = new PostRequest();
        postRequest.setUsername("username");
        postRequest.setTitle("Title");
        postRequest.setContent("Content");
        userService.post(postRequest);
        assertEquals(1,userService.getNumberOfPosts());
        assertEquals(1,userService.getNumberOfPosts("username"));
    }

    @Test
    public void userUploadsAPostWithEmptyBody_throwsExceptionTest(){
        PostRequest postRequest = new PostRequest();
        postRequest.setUsername("username");
        postRequest.setTitle("Title");
        assertThrows(EmptyPostException.class,()->userService.post(postRequest));

    }

    @Test
    public void userViewsPost_PostViewsIncreaseTest(){
        PostRequest postRequest = new PostRequest();
        ViewRequest viewRequest = new ViewRequest();
        postRequest.setUsername("username");
        postRequest.setTitle("Title");
        postRequest.setContent("Content");
        userService.post(postRequest);
        userService.view(viewRequest);

        assertEquals(1L,userService.getTotalNumberOfViews());
        assertEquals(1L,userService.getNumberOfViews(postRequest));
    }
}
