package com.example.springcrud1.config;

import com.example.springcrud1.entities.User;
import com.example.springcrud1.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;


    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Mira Maga", "mira@gmail.com", "999994444", "123456");
        User u2 = new User(null, "Musa Gama", "musa@gmail.com", "888885555", "123456");

        userRepository.saveAll(Arrays.asList(u1, u2));
    }
}
