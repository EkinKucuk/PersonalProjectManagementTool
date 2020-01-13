package com.example.PPMT.repositories;

import org.springframework.stereotype.Repository;

import com.example.PPMT.domain.User;

import org.springframework.data.repository.CrudRepository;


@Repository
public interface UserRepository extends CrudRepository<User, Long>{

}
