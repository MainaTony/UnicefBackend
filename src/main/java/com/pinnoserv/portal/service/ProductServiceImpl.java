package com.pinnoserv.portal.service;

import com.pinnoserv.portal.entity.Product;
import com.pinnoserv.portal.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductRepository productRepository;
    @Override
    public void createProduct(Product product) {

        try{
            Product createProduct = Product.builder()
                    .name(product.getName())
                    .minAmount(product.getMinAmount())
                    .maxAmount(product.getMaxAmount())
                    .maxRepayPeriod(product.getMaxRepayPeriod())
                    .minRepayPeriod(product.getMinRepayPeriod())
                    .recipientType(product.getRecipientType())
                    .dateCreated(LocalDateTime.now())
                    .status(product.getStatus())
                    .inTrash("No")
                    .interestRate(product.getInterestRate())
                    .armotized(product.getArmotized())
                    .reducingBalance(product.getReducingBalance())
                    .installmentPeriod(product.getInstallmentPeriod())
                    .interestUpfront(product.getInterestUpfront())
                    .attachedSupplierId(product.getAttachedSupplierId())
                    .periodUnits(product.getPeriodUnits())
                    .updateCycle(product.getUpdateCycle())
                    .installmentOptions(product.getInstallmentOptions())
                    .cbsProduct(product.getCbsProduct())
                    .loanLimitLoanNumCap(product.getLoanLimitLoanNumCap())
                    .loanLimitLoanAmountCap(product.getLoanLimitLoanAmountCap())
                    .takeChargesUpfront(product.getTakeChargesUpfront())
                    .automatedScoring(product.getAutomatedScoring())
                    .build();
            productRepository.save(createProduct);
        } catch (Exception e){

        }

    }

    @Override
    public Product getProductById(Product product) {
        Product productResponse = null;
        try{
            Long id = product.getId();
            if(productRepository.existsById(id)){
                productResponse = productRepository.findById(id).get();
            }
        }
        catch (Exception e){

        }
        return productResponse;
    }

    @Override
    public List<Product> getAll() {
        List<Product> allProducts = null;
        try{
            allProducts =  productRepository.findAll();
        }
        catch (Exception e){

        }
        return allProducts;
    }

    @Override
    public void updateById(Product product) {
        try{
            Long id = product.getId();
            if(productRepository.existsById(id)){

                String name = product.getName();
                Double minAmount = product.getMinAmount();
                Double maxAmount = product.getMaxAmount();
                Integer maxRepayPeriod = product.getMaxRepayPeriod();
                Integer minRepayPeriod = product.getMinRepayPeriod();
                String recipientType = product.getRecipientType();
                Integer status = product.getStatus();
                Double interestRate = product.getInterestRate();
                String interestType = product.getInterestType();
                Integer armotized = product.getArmotized();
                Double reducingBalance = product.getReducingBalance();
                Integer installmentPeriod = product.getInstallmentPeriod();
                Double interestUpfront = product.getInterestUpfront();
                String attachedSupplierId = product.getAttachedSupplierId();
                String periodUnits = product.getPeriodUnits();
                Integer updateCycle = product.getUpdateCycle();
                String installmentOptions =  product.getInstallmentOptions();
                String cbsProduct = product.getCbsProduct();
                Double loanLimitLoanNumCap = product.getLoanLimitLoanNumCap();
                Double loanLimitLoanAmountCap = product.getLoanLimitLoanAmountCap();
                Double takeChargesUpfront = product.getTakeChargesUpfront();
                Integer automatedScoring = product.getAutomatedScoring();

                Product dbProduct = productRepository.findById(id).get();
                if (!name.isEmpty() && !name.equalsIgnoreCase(dbProduct.getName())){
                    dbProduct.setName(name);
                }
                if (!installmentOptions.isEmpty() && !installmentOptions.equalsIgnoreCase(dbProduct.getInstallmentOptions())){
                    dbProduct.setInstallmentOptions(installmentOptions);
                }
                if (!cbsProduct.isEmpty() && !cbsProduct.equalsIgnoreCase(dbProduct.getCbsProduct())){
                    dbProduct.setCbsProduct(cbsProduct);
                }
                if (!periodUnits.isEmpty() && !periodUnits.equalsIgnoreCase(dbProduct.getPeriodUnits())){
                    dbProduct.setPeriodUnits(periodUnits);
                }
                if (!attachedSupplierId.isEmpty() && !attachedSupplierId.equalsIgnoreCase(dbProduct.getAttachedSupplierId())){
                    dbProduct.setAttachedSupplierId(attachedSupplierId);
                }
                if (!interestType.isEmpty() && !interestType.equalsIgnoreCase(dbProduct.getInterestType())){
                    dbProduct.setInterestType(interestType);
                }
                if (!recipientType.isEmpty() && !recipientType.equalsIgnoreCase(dbProduct.getRecipientType())){
                    dbProduct.setRecipientType(recipientType);
                }

                if (maxRepayPeriod != 0 && maxRepayPeriod != dbProduct.getMaxRepayPeriod()){
                    dbProduct.setMaxRepayPeriod(maxRepayPeriod);
                }
                if (minRepayPeriod != 0 && minRepayPeriod != dbProduct.getMinRepayPeriod()){
                    dbProduct.setMinRepayPeriod(minRepayPeriod);
                }
                if (automatedScoring != 0 && automatedScoring != dbProduct.getAutomatedScoring()){
                    dbProduct.setAutomatedScoring(automatedScoring);
                }
                if (takeChargesUpfront != 0 && takeChargesUpfront != dbProduct.getTakeChargesUpfront()){
                    dbProduct.setTakeChargesUpfront(takeChargesUpfront);
                }
                if (loanLimitLoanAmountCap != 0 && loanLimitLoanAmountCap != dbProduct.getLoanLimitLoanAmountCap()){
                    dbProduct.setLoanLimitLoanAmountCap(loanLimitLoanAmountCap);
                }
                if (minAmount != 0 && minAmount != dbProduct.getMinAmount()){
                    dbProduct.setMinAmount(minAmount);
                }
                if (maxAmount != 0 && maxAmount != dbProduct.getMaxAmount()){
                    dbProduct.setMaxAmount(maxAmount);
                }
                if (status != 0 && status != dbProduct.getStatus()){
                    dbProduct.setStatus(status);
                }
                if (interestRate != 0 && interestRate != dbProduct.getInterestRate()){
                    dbProduct.setInterestRate(interestRate);
                }
                if (armotized != 0 && armotized != dbProduct.getArmotized()){
                    dbProduct.setArmotized(armotized);
                }
                if (reducingBalance != 0 && reducingBalance != dbProduct.getReducingBalance()){
                    dbProduct.setReducingBalance(reducingBalance);
                }
                if (installmentPeriod != 0 && installmentPeriod != dbProduct.getInstallmentPeriod()){
                    dbProduct.setInstallmentPeriod(installmentPeriod);
                }
                if (interestUpfront != 0 && interestUpfront != dbProduct.getInterestUpfront()){
                    dbProduct.setInterestUpfront(interestUpfront);
                }
                if (updateCycle != 0 && updateCycle != dbProduct.getUpdateCycle()){
                    dbProduct.setUpdateCycle(updateCycle);
                }
                if (loanLimitLoanNumCap != 0 && loanLimitLoanNumCap != dbProduct.getLoanLimitLoanNumCap()){
                    dbProduct.setLoanLimitLoanNumCap(loanLimitLoanNumCap);
                }
                productRepository.save(dbProduct);
            }
        }
        catch (Exception e){

        }

    }

    @Override
    public void deleteById(Product product) {
        try{
            Long id = product.getId();
            if(productRepository.existsById(id)){
                productRepository.deleteById(id);
            }
        }
        catch (Exception e){
        }

    }
}
