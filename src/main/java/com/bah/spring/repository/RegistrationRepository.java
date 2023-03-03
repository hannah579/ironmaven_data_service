package com.bah.spring.repository;

import org.springframework.data.repository.CrudRepository;

import com.bah.spring.domain.Registration;

public interface RegistrationRepository extends CrudRepository<Registration, Long>{

}
