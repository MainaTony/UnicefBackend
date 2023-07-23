package com.pinnoserv.portal.service;

import com.pinnoserv.portal.custommodels.ApiResponse;
import com.pinnoserv.portal.custommodels.apiresponsedto.CreateUpdateDeleteResponseDto;
import com.pinnoserv.portal.custommodels.apiresponsedto.ProductById;
import com.pinnoserv.portal.custommodels.apiresponsedto.ProductGetAll;
import com.pinnoserv.portal.entity.Product;

import java.util.List;

public interface ProductService {
    ApiResponse createProduct(Product product);
    ApiResponse getProductById(Product product);
    ApiResponse getAll();
    ApiResponse updateById(Product product);
    ApiResponse deleteById(Product product);
}
