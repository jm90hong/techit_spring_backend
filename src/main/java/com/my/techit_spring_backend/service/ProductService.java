package com.my.techit_spring_backend.service;



import com.my.techit_spring_backend.domain.Product;

import java.util.Optional;

public interface ProductService {

    public Product save(Product product);
    public Optional<Product> findById(Long id);
    public Product update(Long id, Product product);
    public void delete(Long id);

}
