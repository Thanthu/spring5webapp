package com.springboot.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.springboot.spring5webapp.domain.Publisher;

public interface PublisherRespository extends CrudRepository<Publisher, Long> {

}
