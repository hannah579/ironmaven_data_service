package com.bah.spring.repository;


import org.springframework.data.repository.CrudRepository;

import com.bah.spring.domain.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long>{
	
}
