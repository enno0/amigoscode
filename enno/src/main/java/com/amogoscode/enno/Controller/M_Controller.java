package com.amogoscode.enno.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/M")
public class M_Controller {

    // @Autowired
    // CustomerDao customerDao;

    @GetMapping("/UserMain")
    public String getMethodName() {
        return "redirect:" + "/U/Users";
    }

    @GetMapping("/UserRoleMain")
    public String getMethodName2() {
        return "redirect:" + "/Role/Users";
    }

    // @GetMapping("/")
    // public dd greet() {
    // dd d = new dd("Hello",
    // List.of("java", "python", "javascript"),
    // new Person("enno123", 25, 1_000_000));
    // return d;
    // }

    // record Person(String name, int age, double MyCash) {

    // }

    // record dd(
    // String greet,
    // List<String> FPL,
    // Person Person) {
    // }

    // // Read All (Get)
    // @GetMapping("/ReadAll")
    // public ResponseEntity<List<Customer>> getAllCustomers() {
    // List<Customer> customers = customerDao.findAll();

    // if (!customers.isEmpty()) {
    // return new ResponseEntity<>(customers, HttpStatus.OK);
    // } else {
    // return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    // }
    // }

    // // Create (Add)
    // @PostMapping
    // public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
    // Customer savedCustomer = customerDao.save(customer);
    // return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
    // }

    // // Read (Get)
    // @GetMapping("/Read/{CustomerId}")
    // public ResponseEntity<Customer> getCustomer(@PathVariable int CustomerId) {
    // Optional<Customer> customer = customerDao.findById(CustomerId);
    // return customer.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
    // .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    // }

    // // Update
    // @PutMapping("/Update/{CustomerId}")
    // public ResponseEntity<Customer> updateCustomer(@PathVariable int CustomerId,
    // @RequestBody Customer customer) {
    // if (!customerDao.existsById(CustomerId)) {
    // return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    // }
    // customer.setId(CustomerId);
    // Customer updatedUser = customerDao.save(customer);
    // return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    // }

    // // Delete
    // @DeleteMapping("/Delete/{CustomerId}")
    // public ResponseEntity<Void> deleteUser(@PathVariable int CustomerId) {
    // if (!customerDao.existsById(CustomerId)) {
    // return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    // }
    // customerDao.deleteById(CustomerId);
    // return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    // }
}
