package com.hr.spring.jdbc;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;


/**
 * 
 * @Name  : DepartmentDao
 * @Author : LH
 * @Date : 2018年6月28日 上午12:40:57
 * @Version : V1.0
 * 
 * @Description : 不推荐使用 JdbcDaoSupport ，而推荐直接使用 JdbcTemplate 作为Dao 类的成员变量 
 */
@Repository
public class DepartmentDao extends JdbcDaoSupport{

					@Autowired
					public void setDataSource2(DataSource dataSource) {
						setDataSource(dataSource);
					}
					
					public Department get(Integer id) {
						String sql ="select id, dept_name deptName from department  where id = ?";
						RowMapper<Department> rowMapper = new BeanPropertyRowMapper<>(Department.class);
						return getJdbcTemplate().queryForObject(sql, rowMapper,id);
								
					}
}
