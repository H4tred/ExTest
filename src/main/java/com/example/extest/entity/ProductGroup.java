package com.example.extest.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProductGroup {

    @Id
    long id;

    String name;

    public ProductGroup(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public ProductGroup() {

    }

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
}
