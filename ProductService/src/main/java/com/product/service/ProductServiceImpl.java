package com.product.service;

import com.product.entity.Product;
import com.product.exception.ProductServiceCustomException;
import com.product.model.ProductRequest;
import com.product.model.ProductResponse;
import com.product.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;

    @Override
    public long addProduct(ProductRequest productRequest) {
        log.info("Adding Product");
        Product product = Product.builder().productName(productRequest.getName())
                .quantity(productRequest.getQuantity())
                .price(productRequest.getPrice())
                .build();
        productRepository.save(product);
        log.info("");
        return product.getProductId();
    }

    @Override
    public ProductResponse getProductById(long productId) {
        log.info("Get The product for productId: {},", productId);
        Product product = productRepository.findById(productId).orElseThrow(() -> new ProductServiceCustomException("Product with given id not fount", "PRODUCT_NOT_FOUNT"));
        ProductResponse productResponse = new ProductResponse();
        BeanUtils.copyProperties(product, productResponse);

        return productResponse;
    }

    @Override
    public void reduceQuantity(long productId, long quantity) {
        log.info("Reduce Quantity {} for Id : {}", quantity);
        Product product = productRepository.findById(productId).orElseThrow(() -> new ProductServiceCustomException("Product with given id not Fount", "PRODUCT_NOT-FOUNT"));
        if (product.getQuantity() < quantity) {
            throw new ProductServiceCustomException("Product does not have sufficient Quantity", "INSUFFICIENT_QUANTITY");

        }
        product.setQuantity(product.getQuantity() - quantity);
        productRepository.save(product);
        log.info("Product Quantity updated Successfully");

    }

}
