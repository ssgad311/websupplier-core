package com.websuppliercore.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.websuppliercore.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
