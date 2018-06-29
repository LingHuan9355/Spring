package com.hr.spring.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * 
 * @Name  : EmployeeDao
 * @Author : LH
 * @Date : 2018年6月28日 上午12:37:13
 * @Version : V1.0
 * 
 * @Description :
 */
@Repository
public class EmployeeDao {

				@Autowired
				private JdbcTemplate jdbcTemplate;
				
				public Employee get(Integer id) {
					String sql = "select id ,last_name lastName, email  from employee where id = ?";
					RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
					Employee  employee =  jdbcTemplate.queryForObject(sql, rowMapper, id);
					
					return employee;
				}
				
	
	
}