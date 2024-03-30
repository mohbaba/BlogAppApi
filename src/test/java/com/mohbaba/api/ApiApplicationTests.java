package com.mohbaba.api;

import   com.mohbaba.api.data.models.User;
import com.mohbaba.api.data.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class ApiApplicationTests {
//	private UserService userService;
	@Autowired
	private UserRepository repository;

	@Test
	void contextLoads() {
		User user = new User();
		var savedUser = repository.save(user);
		assertNotNull(savedUser);
		assertEquals(1,repository.count());
	}


}
