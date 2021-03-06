package com.example.extest.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    long id;

    String name;

    public Product() {

    }

    public long getProductGroup() {
        return productGroup;
    }

    public void setProductGroup(long productGroup) {
        this.productGroup = productGroup;
    }

    long productGroup;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Product(long id, String name, long productGroup) {
        this.id = id;
        this.name = name;
        this.productGroup = productGroup;
    }
}
