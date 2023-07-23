package com.pinnoserv.portal.controller;

import com.pinnoserv.portal.entity.ApiUsers;
import com.pinnoserv.portal.entity.Product;
import com.pinnoserv.portal.entity.Users;
import com.pinnoserv.portal.custommodels.ApiResponse;
import com.pinnoserv.portal.repositories.ProductRepository;
//import com.pinnoserv.portal.repositories.ProductViewRepository;
//import com.pinnoserv.portal.repositories.ProductViewRepository;
import com.pinnoserv.portal.service.DatabaseService;
import com.pinnoserv.portal.service.ProductService;
import com.pinnoserv.portal.service.RestTemplateServices;
import com.pinnoserv.portal.utils.SharedFunctions;
//import com.pinnoserv.portal.view.ProductView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    private static final Logger LOG = LoggerFactory.getLogger(ProductController.class);
//
    @Autowired
    private Environment environment;

    @Autowired
    DatabaseService dbService;

    @Autowired
    RestTemplateServices restTemplateService;

    @Autowired
    SharedFunctions sharedFunctions;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductService productService;



    @PostMapping("/create")
    public ApiResponse addNewProduct(@RequestBody() Product product) {
        return productService.createProduct(product);
    }

    @PostMapping("/viewById")
    public ApiResponse viewById(@RequestBody Product product) {
        return productService.getProductById(product);
    }

    @PostMapping("/getAll")
    public ApiResponse getAllProducts() {
        return productService.getAll();
    }

    @DeleteMapping("/delete")
    public ApiResponse deleteProductById(@RequestBody Product product){
        return productService.deleteById(product);
    }

    @PostMapping("/updateById")
    public ApiResponse updateById(@RequestBody Product product) {
        return productService.updateById(product);
    }


}
