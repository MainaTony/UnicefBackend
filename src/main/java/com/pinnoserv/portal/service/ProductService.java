package com.pinnoserv.portal.service;

import com.pinnoserv.portal.entity.Product;

import java.util.List;

public interface ProductService {
    void createProduct(Product product);
    Product getProductById(Product product);
    List<Product> getAll();
    void updateById(Product product);
    void deleteById(Product product);
}
