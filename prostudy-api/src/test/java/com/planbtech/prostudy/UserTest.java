package com.planbtech.prostudy;
import com.planbtech.prostudy.entities.model.User;
import com.planbtech.prostudy.repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;


import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    void injectedComponentsAreNotNull(){
        assertThat(entityManager).isNotNull();
        assertThat(userRepository).isNotNull();
    }

    @Test
    void loginUserTest(){
        User user = new User();
        user.setUserName("test");
        user.setUserPassword("test");
        user.setUserEmail("XXXXXXXXXXXXX");
        userRepository.save(user);
        User userTest = userRepository.login("XXXXXXXXXXXXX","test");
        Assertions.assertEquals(userTest, user);
    }

    @Test
    void registerUserTest(){
        User user = new User();
        user.setUserName("test");
        user.setUserPassword("test");
        user.setUserEmail("XXXXXXXXXXXXX");
        userRepository.save(user);
        User userTest = userRepository.findByUserName("test");
        System.out.println(userTest.getUserEmail());
        Assertions.assertEquals(userTest, user);
    }
}
