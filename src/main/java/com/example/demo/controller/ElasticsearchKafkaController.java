package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.KafkaConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/es-kafka")
public class ElasticsearchKafkaController {
    
    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    
    // Endpoint to save a product to Elasticsearch
    @PostMapping("/product")
    public Product saveProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }
    
    // Endpoint to get a product from Elasticsearch by ID
    @GetMapping("/product/{id}")
    public Optional<Product> getProduct(@PathVariable String id) {
        return productRepository.findById(id);
    }
    
    // Endpoint to send a message to Kafka
    @PostMapping("/message")
    public String sendMessage(@RequestParam String message) {
        kafkaTemplate.send("demo-topic", message);
        return "Message sent to Kafka successfully: " + message;
    }
}