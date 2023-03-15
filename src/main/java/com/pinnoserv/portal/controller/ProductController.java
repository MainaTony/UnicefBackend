package com.pinnoserv.portal.controller;

import com.pinnoserv.portal.entity.Product;
import com.pinnoserv.portal.entity.Users;
import com.pinnoserv.portal.custommodels.ApiResponse;
import com.pinnoserv.portal.repositories.ProductRepository;
import com.pinnoserv.portal.repositories.ProductViewRepository;
import com.pinnoserv.portal.service.DatabaseService;
import com.pinnoserv.portal.service.RestTemplateServices;
import com.pinnoserv.portal.utils.SharedFunctions;
import com.pinnoserv.portal.view.ProductView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.math.BigInteger;
import java.util.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    private static final Logger LOG = LoggerFactory.getLogger(ProductController.class);

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
    ProductViewRepository productViewRepository;

    @PostMapping("/getAll")
    public ResponseEntity<?> getProductByOrgId(@RequestBody() Map<String, Object> requestParams) {
        LOG.info("---------------------------STARTING 'FETCH PRODUCTS' ----------------------------");
        LOG.info("PARAMS GOTTEN >> {}", requestParams);
        ApiResponse apiResponse = new ApiResponse();
        HttpStatus httpStatus = null;
        String organisationId = requestParams.containsKey("organisationId") ? requestParams.get("organisationId").toString() : null;
        if (organisationId == null) {
            apiResponse.setResponseCode("01");
            apiResponse.setResponseDescription("Error! Parameter organisationId is required.");
            httpStatus = HttpStatus.BAD_REQUEST;
            LOG.info("PARAMETER {organisationId} NOT FOUND IN REQUEST >> RETURNING WITH RESPONSE CODE >> {}", apiResponse.getResponseCode());
            return new ResponseEntity<>(apiResponse, httpStatus);
        }
        try {
            List<ProductView> products = productViewRepository.findAllByOrganisationIdFk(new BigInteger(organisationId));
            if (products.isEmpty()) {
                LOG.info("DID NOT FIND PRODUCTS >> RETURNING WITH STATUS CODE 01");
                apiResponse.setResponseDescription("Not Found!");
                apiResponse.setResponseCode("01");
                apiResponse.setRecordCount(0);
                apiResponse.setEntity("Did not find any Products for params " + requestParams);
                LOG.info("---------------------------ENDING 'GET PRODUCTS BY ID'--------------------------------'");
                return new ResponseEntity<>(apiResponse, HttpStatus.OK);
            }
            LOG.info("NUMBER OF PRODUCTS FOUND >> {}" + products.size());
            apiResponse.setRecordCount(products.size());
            apiResponse.setEntity(products);
            apiResponse.setResponseCode("00");
            LOG.info("OK >> RETURNING WITH STATUS CODE 00");
        } catch (Exception e) {
            LOG.error("ERROR! " + e.getMessage());
            e.printStackTrace();
            if (environment.getRequiredProperty("api-responses.return-errors", Boolean.class)) {
                Map<String, String> error = new HashMap();
                error.put("error", e.getMessage());
                error.put("cause", e.getCause().toString());
                apiResponse.setEntity(error);
            }
            apiResponse.setResponseCode("01");
            apiResponse.setResponseDescription("Error! Could not fetch Products");
            LOG.info("OK >> RETURNING WITH STATUS CODE 01");
            LOG.info("---------------------------ENDING 'GET PRODUCTS BY ID' WITH ORG ID >> " + organisationId + "--------------------------------'");
            return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        LOG.info("---------------------------ENDING 'GET PRODUCTS BY ID' WITH ORG ID >> " + organisationId + "--------------------------------'");
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PostMapping("/listAll")
    public ResponseEntity<?> getAllProducts() {
        LOG.info("---------------------------STARTING 'FETCH ALL PRODUCTS' ----------------------------");
        ApiResponse apiResponse = new ApiResponse();
        try {
            List<ProductView> products = productViewRepository.findAll();
            if (products.isEmpty()) {
                LOG.info("DID NOT FIND ANY PRODUCTS >> RETURNING WITH STATUS CODE 01");
                apiResponse.setResponseDescription("Not Found!");
                apiResponse.setResponseCode("01");
                apiResponse.setRecordCount(0);
                apiResponse.setEntity("Did not find any Products");
                LOG.info("---------------------------ENDING 'GET ALL PRODUCTS'--------------------------------'");
                return new ResponseEntity<>(apiResponse, HttpStatus.OK);
            }
            LOG.info("NUMBER OF PRODUCTS FOUND >> {}" + products.size());
            apiResponse.setRecordCount(products.size());
            apiResponse.setEntity(products);
            apiResponse.setResponseCode("00");
            LOG.info("OK >> RETURNING WITH STATUS CODE 00");
        } catch (Exception e) {
            LOG.error("ERROR! " + e.getMessage());
            e.printStackTrace();
            if (environment.getRequiredProperty("api-responses.return-errors", Boolean.class)) {
                Map<String, String> error = new HashMap();
                error.put("error", e.getMessage());
                error.put("cause", e.getCause().toString());
                apiResponse.setEntity(error);
            }
            apiResponse.setResponseCode("01");
            apiResponse.setResponseDescription("Error! Could not fetch Any Products");
            LOG.info("OK >> RETURNING WITH STATUS CODE 01");
            LOG.info("---------------------------ENDING GET ALL PRODUCTS --------------------------------'");
            return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        LOG.info("---------------------------ENDING 'GET ALL PRODUCTS --------------------------------'");
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> addNewProduct(@RequestHeader("Authorization") String Authorization, @RequestBody() Product product) {
        LOG.info("---------------------------STARTING 'ADD NEW Product' --------------------------------");
        ApiResponse apiResponse = new ApiResponse();
        HttpStatus responseStatus = HttpStatus.OK;
        try {
            Users user = sharedFunctions.verifyToken(Authorization);
            if(user != null) {
                product.setCreatedBy(user.getId());
            }
            product.setStatus(new BigInteger("1"));
            product.setDateCreated(new Date(System.currentTimeMillis()));
            product.setIntrash("NO");
            Product savedProduct = productRepository.saveAndFlush(product);
            apiResponse.setEntity(savedProduct);
            apiResponse.setResponseCode("00");
            apiResponse.setResponseDescription("Success! Product saved.");
        } catch (Exception e) {
            LOG.error("ERROR! COULD NOT SAVE >> " + e.getMessage());
            e.printStackTrace();
            if (environment.getRequiredProperty("api-responses.return-errors", Boolean.class)) {
                Map<String, String> error = new HashMap();
                error.put("error", e.getMessage());
                error.put("cause", e.getCause().toString());
                apiResponse.setEntity(error);
            }
            apiResponse.setResponseCode("01");
            apiResponse.setResponseDescription("Error! Could not add Product");
            responseStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            LOG.info("OK >> RETURNING WITH STATUS CODE 01");
            LOG.info("---------------------------ENDING 'ADD NEW Product'--------------------------------'");
        }
        return new ResponseEntity<>(apiResponse, responseStatus);
    }

    @PostMapping("/updateById")
    public ResponseEntity<?> updateById(@RequestHeader("Authorization") String Authorization, @RequestBody() Product product) {
        LOG.info("---------------------------STARTING 'UPDATE Product' --------------------------------");
        ApiResponse apiResponse = new ApiResponse();
        HttpStatus responseStatus = HttpStatus.OK;
        try {
            Optional<Product> productSearch = productRepository.findByProductId(product.getProductId());
            if (!productSearch.isPresent()) {
                LOG.info("Product NOT FOUND >> RETURNING WITH STATUS CODE 01");
                apiResponse.setResponseDescription("Product Not Found!");
                apiResponse.setResponseCode("01");
                responseStatus = HttpStatus.OK;
                return new ResponseEntity<>(apiResponse, responseStatus);
            }
            Product productEntity = productSearch.get();
            Users user = sharedFunctions.verifyToken(Authorization);
            /*if(user != null)
                product.setUpdatedBy(user.getId());*/
            productEntity.setMinAmount(product.getMinAmount());
            productEntity.setMaxAmount(product.getMaxAmount());
            productEntity.setMaxRepayPeriod(product.getMaxRepayPeriod());
            productEntity.setMinRepayPeriod(product.getMinRepayPeriod());
            productEntity.setRecipientType(product.getRecipientType());
            productEntity.setInterestRate(product.getInterestRate());
            productEntity.setInterestType(product.getInterestType());
            productEntity.setArmotized(product.getArmotized());
            productEntity.setReducingBalance(product.getReducingBalance());
            productEntity.setInstallmentPeriod(product.getInstallmentPeriod());
            productEntity.setInterestUpfront(product.getInterestUpfront());
            productEntity.setPeriodUnits(product.getPeriodUnits());
            productEntity.setInstallmentOptions(product.getInstallmentOptions());
            productEntity.setCbsProduct(product.getCbsProduct());
            productEntity.setLoanLimitLoanAmountCap(product.getLoanLimitLoanAmountCap());
            productEntity.setLoanLimitLoanNumCap(product.getLoanLimitLoanNumCap());
            productEntity.setTakeChargesUpfront(product.getTakeChargesUpfront());
            productEntity.setAutomatedScoring(product.getAutomatedScoring());
            productEntity.setProgramIdFk(product.getProgramIdFk());
            productEntity.setName(product.getName());
            productEntity.setStatus(product.getStatus());
            productRepository.save(productEntity);
            apiResponse.setEntity(productEntity);
            apiResponse.setResponseCode("00");
            apiResponse.setResponseDescription("Success! Product Saved.");
            LOG.info("OK! RETURNING WITH STATUS CODE 00");
        } catch (Exception e) {
            LOG.error("ERROR! COULD NOT UPDATE >> " + e.getMessage());
            e.printStackTrace();
            if (environment.getRequiredProperty("api-responses.return-errors", Boolean.class)) {
                Map<String, String> error = new HashMap();
                error.put("error", e.getMessage());
                error.put("cause", e.getCause() != null ? e.getCause().toString() : "");
                apiResponse.setEntity(error);
            }
            apiResponse.setResponseCode("01");
            apiResponse.setResponseDescription("Error! Could not add Product");
            responseStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            LOG.info("OK >> RETURNING WITH STATUS CODE 01");
        }
        LOG.info("---------------------------ENDING 'UPDATE Product'--------------------------------'");
        return new ResponseEntity<>(apiResponse, responseStatus);
    }

    @PostMapping("/viewById")
    public ResponseEntity<?> viewById(@RequestBody() Map<String, Object> requestParams) {
        LOG.info("---------------------------STARTING 'VIEW PRODUCT' --------------------------------");
        ApiResponse apiResponse = new ApiResponse();
        HttpStatus responseStatus = HttpStatus.OK;
        try {
            String productId = requestParams.containsKey("productId") ? requestParams.get("productId").toString() : null;
            if (productId == null) {
                apiResponse.setResponseCode("01");
                apiResponse.setResponseDescription("Error! Parameter productId is required.");
                responseStatus = HttpStatus.BAD_REQUEST;
                LOG.info("PARAMETER {productId} NOT FOUND IN REQUEST >> RETURNING WITH RESPONSE CODE >> {}", apiResponse.getResponseCode());
                return new ResponseEntity<>(apiResponse, responseStatus);
            }
            Optional<ProductView> productSearch = productViewRepository.findByProductId(new BigInteger(productId));
            if (!productSearch.isPresent()) {
                LOG.info("PROGRAM NOT FOUND >> RETURNING WITH STATUS CODE 01");
                apiResponse.setResponseDescription("Product Not Found!");
                apiResponse.setResponseCode("01");
                responseStatus = HttpStatus.OK;
                return new ResponseEntity<>(apiResponse, responseStatus);
            }
            ProductView productEntity = productSearch.get();
            apiResponse.setEntity(productEntity);
            apiResponse.setResponseCode("00");
            apiResponse.setResponseDescription("Success! Product Fetched.");
            LOG.info("OK! RETURNING WITH STATUS CODE 00");
        } catch (Exception e) {
            LOG.error("ERROR! COULD NOT FETCH PRODUCT >> " + e.getMessage());
            e.printStackTrace();
            if (environment.getRequiredProperty("api-responses.return-errors", Boolean.class)) {
                Map<String, String> error = new HashMap();
                error.put("error", e.getMessage());
                error.put("cause", e.getCause() != null ? e.getCause().toString() : "");
                apiResponse.setEntity(error);
            }
            apiResponse.setResponseCode("01");
            apiResponse.setResponseDescription("Error! Could not View Product");
            responseStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            LOG.info("OK >> RETURNING WITH STATUS CODE 01");
        }
        LOG.info("---------------------------ENDING 'VIEW PRODUCT'--------------------------------'");
        return new ResponseEntity<>(apiResponse, responseStatus);
    }
}
