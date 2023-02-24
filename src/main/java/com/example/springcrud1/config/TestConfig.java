package com.example.springcrud1.config;

import com.example.springcrud1.entities.Category;
import com.example.springcrud1.entities.Order;
import com.example.springcrud1.entities.Product;
import com.example.springcrud1.entities.User;
import com.example.springcrud1.entities.enums.OrderStatus;
import com.example.springcrud1.repositories.CategoryRepository;
import com.example.springcrud1.repositories.OrderRepository;
import com.example.springcrud1.repositories.ProductRepository;
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

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        Product p1 = new Product(null, "The Lord of The Rings", "Lorem ipsum dolor sit amet", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet", 2190.0, "");
        Product p3 = new Product(null, "Macbook", "Nam eleifend maximus tortor", 1250.0, "");
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus", 1200.0, "");
        Product p5 = new Product(null, "Rail for Dummies", "Cras fringilla convallis sem vel", 100.99, "");

        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));

        User u1 = new User(null, "Mira Maga", "mira@gmail.com", "999994444", "123456");
        User u2 = new User(null, "Musa Gama", "musa@gmail.com", "888885555", "123456");

        Order o1 = new Order(null, Instant.parse("2023-02-18T20:53:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2023-02-20T14:13:07Z"), OrderStatus.WAITING_PAYMENT, u2);
        Order o3 = new Order(null, Instant.parse("2023-02-23T08:55:07Z"), OrderStatus.WAITING_PAYMENT, u1);

        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1,o2,o3));
    }
}
