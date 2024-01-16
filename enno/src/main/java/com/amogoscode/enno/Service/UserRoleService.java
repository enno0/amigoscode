package com.amogoscode.enno.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amogoscode.enno.DAO.UserRoleDAO;
import com.amogoscode.enno.Model.UserRole;

@Service
public class UserRoleService {
    @Autowired
    private UserRoleDAO userRoleDAO;

    public void addUserRole(UserRole userRole) {
        userRoleDAO.save(userRole);
    }

    public Optional<UserRole> getUserRoleById(int id) {
        return userRoleDAO.findById(id);
    }

    public List<UserRole> getAllUserRoles() {
        return userRoleDAO.findAll();
    }

    public void deleteUserRole(int id) {
        userRoleDAO.deleteById(id);
    }

    public void updateUserRole(UserRole userRole) {
        userRoleDAO.save(userRole);
    }

}
