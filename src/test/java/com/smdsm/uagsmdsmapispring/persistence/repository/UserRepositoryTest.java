package com.smdsm.uagsmdsmapispring.persistence.repository;

import com.smdsm.uagsmdsmapispring.persistence.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@DataJpaTest(properties = {"spring.jpa.hibernate.ddl-auto = create-drop"})
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;
    private List<User> allUsers;

    //TODO: Try using DB different from PostgreSQL because some incompatibilities whit H2 DB syntax. e.g. Add column names with "´name´"
    /*@BeforeEach
    void setup(){
        Function<String, LocalDate> parser = LocalDate::parse;
        allUsers = Arrays.asList(
                new User(1, "Ivan", "Valadez", "male", parser.apply("1996-02-09")),
                new User(2, "Aaron", "Ruiz", "male", parser.apply("2000-06-20")),
                new User(3, "Susana", "Perez", "female", parser.apply("1998-05-08")),
                new User(4, "Andrea", "Amante", "female", parser.apply("2001-07-22")),
                new User(5, "Raul", "Rios", "male", parser.apply("1985-11-30"))
        );
        userRepository.saveAll(allUsers);
    }

    @Test
    void findAll() {
        List<User> actualUsers = userRepository.findAll();

        assertEquals(allUsers, actualUsers);
    }*/
}