package com.capg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.bean.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
