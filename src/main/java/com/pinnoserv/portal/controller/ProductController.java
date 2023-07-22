//package com.pinnoserv.portal.controller;
//
//import com.pinnoserv.portal.entity.ApiUsers;
//import com.pinnoserv.portal.entity.Product;
//import com.pinnoserv.portal.entity.Users;
//import com.pinnoserv.portal.custommodels.ApiResponse;
//import com.pinnoserv.portal.repositories.ProductRepository;
////import com.pinnoserv.portal.repositories.ProductViewRepository;
////import com.pinnoserv.portal.repositories.ProductViewRepository;
//import com.pinnoserv.portal.service.DatabaseService;
//import com.pinnoserv.portal.service.ProductService;
//import com.pinnoserv.portal.service.RestTemplateServices;
//import com.pinnoserv.portal.utils.SharedFunctions;
////import com.pinnoserv.portal.view.ProductView;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.env.Environment;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import java.math.BigInteger;
//import java.time.LocalDateTime;
//import java.util.*;
//
//@RestController
//@RequestMapping("/product")
//public class ProductController {
//
//    private static final Logger LOG = LoggerFactory.getLogger(ProductController.class);
////
//    @Autowired
//    private Environment environment;
//
//    @Autowired
//    DatabaseService dbService;
//
//    @Autowired
//    RestTemplateServices restTemplateService;
//
//    @Autowired
//    SharedFunctions sharedFunctions;
//
//    @Autowired
//    ProductRepository productRepository;
//
//    @Autowired
//    ProductService productService;
//
//
//
//    @PostMapping("/create")
//    public ResponseEntity<String> addNewProduct(@RequestBody() Product product) {
//    try{
//        productService.createProduct(product);
//    }
//    catch (Exception e){
//
//    }
//        return ResponseEntity.ok("Product Saved");
//    }
//
//    @PostMapping("/viewById")
//    public ResponseEntity<Product> viewById(@RequestBody Product product) {
//        Product idProduct = null;
//        try{
//            idProduct = productService.getProductById(product);
//        }
//        catch (Exception e){
//        }
//        return ResponseEntity.ok(idProduct);
//    }
//
//    @PostMapping("/getAll")
//    public ResponseEntity<List<Product>> getAllProducts() {
//        List<Product> allProducts = null;
//        try{
//            allProducts = productService.getAll();
//        }
//        catch (Exception e){
//
//        }
//        return ResponseEntity.ok(allProducts);
//    }
//
//    @DeleteMapping("/delete")
//    public ResponseEntity<String> deleteProductById(@RequestBody Product product){
//        try{
//            productService.deleteById(product);
//        }
//        catch (Exception e){
//
//        }
//    return ResponseEntity.ok("Product Deleted Successfully");
//    }
//
//    @PostMapping("/updateById")
//    public ResponseEntity<String> updateById(@RequestBody Product product) {
//        try{
//            productService.updateById(product);
//        }
//        catch (Exception e){
//        }
//        return ResponseEntity.ok("Product Updated Succesfully");
//
//    }
//
//
//}
