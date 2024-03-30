package com.mohbaba.api.utils;

import com.mohbaba.api.data.repositories.UserRepository;
import com.mohbaba.api.exceptions.UsernameExistsException;

public class UserUtils {

    private UserRepository userRepository;

    public void checkUsernameExists(String user){
        if (userRepository.existsByUsername(user))throw new UsernameExistsException(
                "Username exists");
    }
}
