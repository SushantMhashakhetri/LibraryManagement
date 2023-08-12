package com.library.repository;

import org.springframework.stereotype.Repository;

import com.library.Entities.User;

import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface UserRepo extends JpaRepository<User,Long>{

}
