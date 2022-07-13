package com.example.extest.repository;

import com.example.extest.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByProductGroupId(long productGroupId);

    List<Product> findAllByProductCategoryIdAndProductGroup(long employeeId, String function, Long productCategoryId, Set<Long> productIds);

    List<Product> findAllNOProductCategory(Set<Long> productIds);

    List<Product> findAllRentNOProductCategory(Set<Long> productIds);

    List<Product> findAllByProductCategoryId(Long id);

    List<Product> findAllProductId();

    Set<Long> productsWithNoCategories(Set<Long> productIds);
}
