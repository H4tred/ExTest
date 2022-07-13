package com.example.extest.service;

import com.example.extest.entity.Product;
import com.example.extest.repository.ProductRepository;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
@NoArgsConstructor
@Transactional
public class ProductService {

    @Getter
    @Setter(onMethod_ = @Autowired)
    private ProductRepository productRepository;

    public void clear() {
        productRepository.deleteAll();
    }

    public Product findById(long productId) {

        Optional<Product> product = productRepository.findById(productId);

        return product.orElse(null);

    }

    public List<Product> findByProductGroup(long productGroupId){
        return productRepository.findByProductGroupId(productGroupId);
    }


    public List<Product> findAllByProductCategoryIdAndProductGroup(long employeeId, String function, Long productCategoryId, Set<Long> productIds) {
        return productRepository.findAllByProductCategoryIdAndProductGroup(employeeId, function, productCategoryId, productIds);
    }

    public List<Product> productsWithNoCategory(Set<Long> productIds){
        return productRepository.findAllNOProductCategory(productIds);
    }

    public List<Product> rentProductsWithNoCategory(Set<Long> productIds){
        return productRepository.findAllRentNOProductCategory(productIds);
    }

    public List<Product> findAllByProductCategoryId(Long id) {
        return productRepository.findAllByProductCategoryId(id);
    }


    public Set<Long> findAllProductId() {
        List<Product> products = productRepository.findAllProductId();

        return products.stream().map(product -> product.getId()).collect(Collectors.toSet());
    }

    public Set<Long> productsWithNoCategories(Set<Long> productIds){
        return productRepository.productsWithNoCategories(productIds);
    }
}
