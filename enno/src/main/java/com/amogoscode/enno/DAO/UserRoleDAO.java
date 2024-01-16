package com.amogoscode.enno.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amogoscode.enno.Model.UserRole;

public interface UserRoleDAO extends JpaRepository<UserRole, Integer> {

}
