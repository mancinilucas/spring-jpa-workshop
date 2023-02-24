package com.example.springcrud1.config;

import com.example.springcrud1.entities.Order;
import com.example.springcrud1.entities.User;
import com.example.springcrud1.entities.enums.OrderStatus;
import com.example.springcrud1.repositories.OrderRepository;
import com.example.springcrud1.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;


    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Mira Maga", "mira@gmail.com", "999994444", "123456");
        User u2 = new User(null, "Musa Gama", "musa@gmail.com", "888885555", "123456");

        Order o1 = new Order(null, Instant.parse("2023-02-18T20:53:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2023-02-20T14:13:07Z"), OrderStatus.WAITING_PAYMENT, u2);
        Order o3 = new Order(null, Instant.parse("2023-02-23T08:55:07Z"), OrderStatus.WAITING_PAYMENT, u1);

        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1,o2,o3));
    }
}
