package com.example.extest.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductControllerTest {

    /*THIS IS JUST A UNIT TEST*/

    @Test
    void product() {
        ProductController productController = new ProductController(); //Arrange
        String response = productController.Product("Gloves"); //Act
        assertEquals("Product is, Gloves", response); //Assert
    }

}