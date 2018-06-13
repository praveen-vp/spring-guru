package com.pvp.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.pvp.spring5webapp.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
