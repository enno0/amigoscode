package com.amogoscode.enno.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amogoscode.enno.DAO.CustomerDao;
import com.amogoscode.enno.Model.Customer;

@RestController
@RequestMapping("/M")
public class M_Controller {
    @Autowired
    ExceptionContr exceptionContr;
    @Autowired
    CustomerDao customerDao;

    @GetMapping("/")
    public dd greet() {
        dd d = new dd("Hello",
                List.of("java", "python", "javascript"),
                new Person("enno123", 25, 1_000_000));
        return d;
    }

    record Person(String name, int age, double MyCash) {

    }

    record dd(
            String greet,
            List<String> FPL,
            Person Person) {
    }

    // Read All (Get)
    @GetMapping("/ReadAll")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerDao.findAll();

        if (!customers.isEmpty()) {
            return new ResponseEntity<>(customers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Create (Add)
    @PostMapping
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        Customer savedCustomer = customerDao.save(customer);
        return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
    }

    // Read (Get)
    @GetMapping("/Read/{CustomerId}")
    public ResponseEntity<Customer> getCustomer(@PathVariable int CustomerId) {
        Optional<Customer> customer = customerDao.findById(CustomerId);
        return customer.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Update
    @PutMapping("/Update/{CustomerId}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable int CustomerId, @RequestBody Customer customer) {
        if (!customerDao.existsById(CustomerId)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        customer.setId(CustomerId);
        Customer updatedUser = customerDao.save(customer);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    // Delete
    @DeleteMapping("/Delete/{CustomerId}")
    public ResponseEntity<Void> deleteUser(@PathVariable int CustomerId) {
        if (!customerDao.existsById(CustomerId)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        customerDao.deleteById(CustomerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
