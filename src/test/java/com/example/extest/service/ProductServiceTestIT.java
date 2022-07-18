package com.example.extest.service;

import com.example.extest.ExTestApplication;
import com.example.extest.entity.Product;
import com.example.extest.repository.ProductRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;


@SpringBootTest(classes = ExTestApplication.class)
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@ActiveProfiles("test")
class ProductServiceTestIT {

    @Autowired
    ProductRepository productRepository;

    @Test
    void findById() {

    }

}