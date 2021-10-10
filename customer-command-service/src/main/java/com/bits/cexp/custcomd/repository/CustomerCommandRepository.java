package com.bits.cexp.custcomd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bits.cexp.custcomd.model.Customer;

@Repository
public interface CustomerCommandRepository extends JpaRepository<Customer, Long> {

}
