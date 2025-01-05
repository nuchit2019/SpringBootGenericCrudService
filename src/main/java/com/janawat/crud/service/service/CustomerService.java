package com.janawat.crud.service.service;

import com.janawat.crud.service.entity.Customer;
import com.janawat.crud.service.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService extends GenericCrudService<Customer, Long> {
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    protected JpaRepository<Customer, Long> getRepository() {
        return customerRepository;
    }
}
