package com.example.extest.entity;

import javax.persistence.Id;

public class Product {
    @Id
    long id;

    public long getId() {
        return id;
    }

}
