package com.pinnoserv.portal.service;

import com.pinnoserv.portal.custommodels.apiresponsedto.CreateUpdateDeleteResponseDto;
import com.pinnoserv.portal.custommodels.apiresponsedto.ProductById;
import com.pinnoserv.portal.custommodels.apiresponsedto.ProductGetAll;
import com.pinnoserv.portal.entity.Product;

import java.util.List;

public interface ProductService {
    CreateUpdateDeleteResponseDto createProduct(Product product);
    ProductById getProductById(Product product);
    ProductGetAll getAll();
    CreateUpdateDeleteResponseDto updateById(Product product);
    CreateUpdateDeleteResponseDto deleteById(Product product);
}
