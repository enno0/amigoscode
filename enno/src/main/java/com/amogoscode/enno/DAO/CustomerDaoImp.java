// package com.amogoscode.enno.DAO;

// import java.util.List;

// import javax.sql.DataSource;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.context.annotation.Primary;
// import org.springframework.dao.DataAccessException;
// import org.springframework.jdbc.core.JdbcTemplate;
// import org.springframework.stereotype.Repository;

// import com.amogoscode.enno.Model.Customer;
// import com.amogoscode.enno.RowMapper.CustomerRowMapper;

// @Primary
// @Repository
// public class CustomerDaoImp implements CustomerDao2 {
// private final JdbcTemplate jdbcTemplate;
// private static final Logger logger =
// LoggerFactory.getLogger(CustomerDaoImp.class);

// public CustomerDaoImp(DataSource dataSource) {
// this.jdbcTemplate = new JdbcTemplate(dataSource);
// }

// @Override
// public int deleteCustomer(int id) {
// String sql = "DELETE FROM `Customer` WHERE `id`=?";
// return jdbcTemplate.update(sql, id);
// }

// @Override
// public List<Customer> getAllCustomer() {
// String sql = "SELECT * FROM `Customer`";
// return jdbcTemplate.query(sql, new CustomerRowMapper());
// }

// @Override
// public Customer getCustomerById(int id) {
// String sql = "SELECT * FROM `Customer` WHERE `id`=?";
// return jdbcTemplate.queryForObject(sql, new Object[] { id }, new
// CustomerRowMapper());
// }

// @Override
// public void saveCustomer(Customer customer) {
// try {
// String sql = "INSERT INTO `Customer`(`name`, `email`, `age`) VALUES (?,?,?)";
// jdbcTemplate.update(sql, customer.getName(), customer.getEmail(),
// customer.getAge());

// // Use logging instead of System.out.println for production code
// logger.info("Customer saved!");
// } catch (

// DataAccessException e) {
// // Handle exception (e.g., log, throw custom exception, etc.)
// logger.error("Error saving Customer", e);
// }

// }

// @Override
// public int updateCustomer(Customer customer) {
// try {
// String sql = "UPDATE `Customer` SET `name`=?, `eamil`=?, `age`=?
// WHERE`id`=?";
// return jdbcTemplate.update(sql, customer.getName(), customer.getEmail(),
// customer.getAge(),
// customer.getId());
// } catch (DataAccessException e) {
// // Handle exception (e.g., log, throw custom exception, etc.)
// e.printStackTrace();
// return -1; // Or throw a custom exception
// }
// }

// }
