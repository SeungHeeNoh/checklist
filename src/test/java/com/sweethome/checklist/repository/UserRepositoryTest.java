package com.sweethome.checklist.repository;

import com.sweethome.checklist.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void givenNothing_whenSearchUserList_thenReturningUserList() {
        // given

        // when
        List<User> resultList = userRepository.findAll();

        // then
        assertThat(resultList.size())
                .isEqualTo(1);
    }
}