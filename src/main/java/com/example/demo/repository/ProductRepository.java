package com.example.demo.repository;

import com.example.demo.model.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ProductRepository extends ElasticsearchRepository<Product, String> {
    // Spring Data will automatically implement this interface
    // We can add custom query methods here if needed
}