package com.amogoscode.enno.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amogoscode.enno.Model.Customer;

public interface CustomerDao extends JpaRepository<Customer, Integer> {

}
