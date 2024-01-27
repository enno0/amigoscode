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

import com.amogoscode.enno.Model.UserRole;
import com.amogoscode.enno.Service.UserRoleService;

@Controller
@RequestMapping("/Role")
public class UserRolrComntroller {

    @Autowired
    private UserRoleService userRoleService;

    @GetMapping("/Users")
    public String getAllUsers(Model model) {
        // Fetch the list of customers from the service
        List<UserRole> userRole = userRoleService.getAllUserRoles();

        // Add the list of customers to the model
        model.addAttribute("userRole", userRole);

        // Return the Thymeleaf template name (without the file extension)
        return "userRole";
    }

    @GetMapping("/Users/add")
    public String showAddForm(Model model) {
        model.addAttribute("userRole", new UserRole());
        return "add_userRole";
    }

    @PostMapping("/Users/add")
    public String addUser_Role(@ModelAttribute UserRole userRole) {
        // Add validation and error handling if needed
        userRoleService.addUserRole(userRole);
        return "redirect:/Role/Users";
    }

    @GetMapping("/Users/update/{id}")
    public String showUpdateForm(@PathVariable int id, Model model) {
        System.out.printf("done", id);
        UserRole userRole = userRoleService.getUserRoleById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        model.addAttribute("userRole", userRole);
        return "update_userRole";
    }

    @PostMapping("/Users/update/{id}")
    public String update_The_User(@PathVariable int id, @ModelAttribute UserRole updatedUserRole) {
        Optional<UserRole> optionalUserRole = userRoleService.getUserRoleById(id);

        if (optionalUserRole.isPresent()) {
            UserRole existingUserRole = optionalUserRole.get();
            // Update existingCustomer properties with updatedCustomer properties
            existingUserRole.setUserName(updatedUserRole.getUserName());
            existingUserRole.setRole(updatedUserRole.getRole());
            // Save the updated customer
            userRoleService.updateUserRole(existingUserRole);
            return "redirect:/Role/Users";
        } else {
            // Handle the case where the customer with the given ID is not found
            // You might want to show an error page or redirect to a different page
            return "error"; // or return an error view
        }
    }

    @GetMapping("/Users/delete/{id}")
    public String Delete(@PathVariable int id) {
        userRoleService.deleteUserRole(id);
        return "redirect:/Role/Users";
    }

}
