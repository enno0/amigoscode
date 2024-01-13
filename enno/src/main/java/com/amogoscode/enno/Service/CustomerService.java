package com.amogoscode.enno.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amogoscode.enno.DAO.CustomerDao;
import com.amogoscode.enno.Model.Customer;

@Service
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;

    public void addCustomer(Customer customer) {
        customerDao.save(customer);
    }

    public Optional<Customer> getCustomerById(int id) {
        return customerDao.findById(id);
    }

    public List<Customer> getAllCustomers() {
        return customerDao.findAll();
    }

    public void deleteCustomer(int id) {
        customerDao.deleteById(id);
    }

    public void updateCustomer(Customer customer) {
        customerDao.save(customer);
    }
}
