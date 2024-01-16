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

import com.amogoscode.enno.Model.My_User;
import com.amogoscode.enno.Service.UserService;

@Controller
@RequestMapping("/U")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/Users")
    public String getAllUsers(Model model) {
        // Fetch the list of customers from the service
        List<My_User> user = userService.getAllUsers();

        // Add the list of customers to the model
        model.addAttribute("user", user);

        // Return the Thymeleaf template name (without the file extension)
        return "user";
    }

    @GetMapping("/users/add")
    public String showAddForm(Model model) {
        model.addAttribute("user", new My_User());
        return "add_user";
    }

    @PostMapping("/users/add")
    public String addUser(@ModelAttribute My_User user) {
        // Add validation and error handling if needed
        userService.addUser(user);
        return "redirect:/U/Users";
    }

    @GetMapping("/Users/update/{id}")
    public String showUpdateForm(@PathVariable int id, Model model) {
        System.out.printf("done", id);
        My_User user = userService.getUserById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        model.addAttribute("user", user);
        return "update_user";
    }

    @PostMapping("/Users/update/{id}")
    public String updateUser(@PathVariable int id, @ModelAttribute My_User updatedUser) {
        Optional<My_User> optionalUser = userService.getUserById(id);

        if (optionalUser.isPresent()) {
            My_User existingUser = optionalUser.get();
            // Update existingCustomer properties with updatedCustomer properties
            existingUser.setFullName(updatedUser.getFullName());
            existingUser.setUserName(updatedUser.getUserName());
            existingUser.setPassword(updatedUser.getPassword());
            // Save the updated customer
            userService.updateUser(existingUser);
            return "redirect:/U/Users";
        } else {
            // Handle the case where the customer with the given ID is not found
            // You might want to show an error page or redirect to a different page
            return "error"; // or return an error view
        }
    }

    @GetMapping("/Users/delete/{id}")
    public String Delete(@PathVariable int id) {
        userService.deleteUser(id);
        return "redirect:/U/Users";
    }

}
