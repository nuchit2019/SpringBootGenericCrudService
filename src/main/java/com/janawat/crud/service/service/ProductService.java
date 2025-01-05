package com.janawat.crud.service.service;

import com.janawat.crud.service.entity.Product;

import com.janawat.crud.service.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends GenericCrudService<Product, Long> {

    @Autowired
    private ProductRepository productRepository;

    @Override
    protected JpaRepository<Product, Long> getRepository() {
        return productRepository;
    }

}
