package com.sb.ecommerceui.domain.service;

import com.sb.ecommerceui.domain.model.Product;
import com.sb.ecommerceui.domain.repository.ProductRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
        this.repository.saveAll(defaultInitialData());
    }

    private static List<Product> defaultInitialData() {
        return List.of(
                new Product(1L, "Product 1", "Description P1", new BigDecimal("11")),
                new Product(2L, "Product 2", "Description P2", BigDecimal.TEN),
                new Product(3L, "Product 3", "Description P3", BigDecimal.ONE)
        );
    }

    public List<Product> findAll() {
        List<Product> list = new ArrayList();
        repository.findAll().forEach(list::add);
        return list;
    }


    public Optional<Product> find(Long id) {
        return repository.findById(id);
    }

    public Product create(Product item) {
        // To ensure the item ID remains unique, use the current timestamp.
        Product updated = new Product(new Date().getTime(), item.getName(), item.getDescription(), item.getPrice());
        return repository.save(updated);
    }

    public Optional<Product> update( Long id, Product newItem) {
        return repository.findById(id).map(oldItem -> repository.save(oldItem.updateWith(newItem)));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }


}
