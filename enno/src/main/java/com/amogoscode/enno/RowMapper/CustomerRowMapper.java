package com.amogoscode.enno.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.amogoscode.enno.Model.Customer;

public class CustomerRowMapper implements RowMapper<Customer> {

    @Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Customer customer = new Customer();

        customer.setId(rs.getInt("id"));
        customer.setAge(rs.getInt("age"));
        customer.setName(rs.getString("name"));
        customer.setEmail(rs.getString("eamil"));
        return customer;
    }

}
