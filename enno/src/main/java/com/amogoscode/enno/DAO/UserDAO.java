package com.amogoscode.enno.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amogoscode.enno.Model.My_User;

public interface UserDAO extends JpaRepository<My_User, Integer> {

}
