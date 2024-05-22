package com.romeoh20.goalhub.repositories;

import com.romeoh20.goalhub.models.User;
import com.romeoh20.goalhub.models.data.UserRepository;
import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional
public class UserRepositoryTests {
    // 1. Arrange 2. Act 3. Assert

    // 1. Test that the repository saves user
    // 2. Test find by username method
    // 3.

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void setUp(){
        User testUser = new User("PegLegJoe","Treasure12");
        User savedTestUser = userRepository.save(testUser);
    }

    @Test
    public void testSaveUser(){

        User user = new User("PegLegJoe","Treasure12");

        User savedUser = userRepository.save(user);

        Assertions.assertThat(savedUser).isNotNull();
        Assertions.assertThat(savedUser.getId()).isGreaterThan(0);
    }
    @Test // Update this test when email is added to user object
    public void testFindByUsername(){

        User foundUser = userRepository.findByUsername("PegLegJoe");

        Assertions.assertThat(foundUser).isNotNull();
        Assertions.assertThat(foundUser.getId()).isGreaterThan(0);

    }
}
