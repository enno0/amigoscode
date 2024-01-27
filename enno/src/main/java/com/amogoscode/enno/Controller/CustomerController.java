package com.amogoscode.enno.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.amogoscode.enno.Model.Customer;
import com.amogoscode.enno.Service.CustomerService;

@Controller
@RequestMapping("/customers")

public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public String getAllCustomers(Model model) {
        // Fetch the list of customers from the service
        List<Customer> customers = customerService.getAllCustomers();

        // Add the list of customers to the model
        model.addAttribute("customers", customers);

        // Return the Thymeleaf template name (without the file extension)
        return "customer";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "add_customer";
    }

    @PostMapping("/add")
    public String addCustomer(@ModelAttribute Customer customer) {
        // Add validation and error handling if needed
        customerService.addCustomer(customer);
        return "redirect:/customers/customers";
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable int id, Model model) {
        Customer customer = customerService.getCustomerById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        model.addAttribute("customer", customer);
        return "update_customer";
    }

    @PostMapping("/update/{id}")
    public String updateCustomer(@PathVariable int id, @ModelAttribute Customer updatedCustomer) {
        Optional<Customer> optionalCustomer = customerService.getCustomerById(id);

        if (optionalCustomer.isPresent()) {
            Customer existingCustomer = optionalCustomer.get();
            // Update existingCustomer properties with updatedCustomer properties
            existingCustomer.setName(updatedCustomer.getName());
            existingCustomer.setEmail(updatedCustomer.getEmail());
            existingCustomer.setAge(updatedCustomer.getAge());
            existingCustomer.setNum(updatedCustomer.getNum());
            // Save the updated customer
            customerService.updateCustomer(existingCustomer);
            return "redirect:/customers/customers";
        } else {
            // Handle the case where the customer with the given ID is not found
            // You might want to show an error page or redirect to a different page
            return "redirect:/customers/customers"; // or return an error view
        }
    }

    @GetMapping("/delete/{id}")
    public String Delete(@PathVariable int id) {
        customerService.deleteCustomer(id);
        return "redirect:/customers/customers";
    }

}
