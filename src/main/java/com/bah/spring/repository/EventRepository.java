package com.bah.spring.repository;

import org.springframework.data.repository.CrudRepository;

import com.bah.spring.domain.Event;

public interface EventRepository extends CrudRepository<Event, Long> {

}
