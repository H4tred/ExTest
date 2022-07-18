package com.example.extest.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ProductController.class)
class ProductControllerIT {

    /*THIS IS AN INTEGRATION TEST*/

    @Autowired
    private MockMvc mvc;

    @Test
    void product() throws Exception {
        RequestBuilder request = get("/product");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("Product is, TestProduct", result.getResponse().getContentAsString());
    }

    @Test
    void productWithName() throws Exception {
        mvc.perform(get("/product?name=Gloves"))
                .andExpect(content().string("Product is, Gloves"));
    }
}