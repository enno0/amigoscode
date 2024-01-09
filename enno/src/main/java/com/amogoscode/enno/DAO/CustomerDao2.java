package com.amogoscode.enno.DAO;

import java.util.List;

import com.amogoscode.enno.Model.Customer;

public interface CustomerDao2 {
    int deleteCustomer(int id);

    List<Customer> getAllCustomer();

    Customer getCustomerById(int id);

    void saveCustomer(Customer customer);

    int updateCustomer(Customer customer);

}
