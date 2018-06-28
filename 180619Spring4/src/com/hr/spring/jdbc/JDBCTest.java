package com.hr.spring.jdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

/**
 * 
 * @Name  : JDBCTest
 * @Author : LH
 * @Date : 2018年6月27日 下午11:35:15
 * @Version : V1.0
 * 
 * @Description :
 */
public class JDBCTest {

				private ApplicationContext context = null;
				private JdbcTemplate jdbcTemplate ;
				private EmployeeDao employeeDao;
				private DepartmentDao departmentDao;
				private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
				
				{
					context = new ClassPathXmlApplicationContext("applicationContext.xml");
					jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
					employeeDao = context.getBean(EmployeeDao.class);
					departmentDao = context.getBean(DepartmentDao.class);
					namedParameterJdbcTemplate = context.getBean(NamedParameterJdbcTemplate.class);
				}
				
				/**
				 * 使用具名参数时可以使用，update(String sql, SqlParameterSource paramSource) 方法进行更新操作
				 *1.SQL 语句中的参数和类的属性一致
				 *2.使用 SqlParameterSource 的 BeanPropertySqlParameterSource 实现类作为参数。
				 */
				@Test
				public void testNamedParameterJdbcTemplate2() {
					String sql ="insert into employee (LAST_NAME,EMAIL,DEPT_ID) values( :lastName , :email, :deptId)";
							
					Employee employee = new Employee();
						employee.setLastName("XYZ");
						employee.setEmail("xyz@sina.com");
						employee.setDeptId(4);
						
					SqlParameterSource paramSource = new BeanPropertySqlParameterSource(employee);
					
					namedParameterJdbcTemplate.update(sql, paramSource);
				}
				
				/**
				 * 使用具名参数：可以为参数起名字，
				 * 1.优点：若有多个参数，则不用再去对应位置，直接对象参数名字，便于维护
				 * 2.缺点：较为麻烦
				 */
				@Test 
				public void testNamedParameterJdbcTemplate() {
					String sql ="insert into employee (LAST_NAME,EMAIL,DEPT_ID) values( :ln , :email, :deptid)";
					
					Map<String, Object> map = new HashMap<>();
					map.put("ln", "Ksana");
					map.put("email", "ksana@sina.com");
					map.put("deptid", 4);
					
					namedParameterJdbcTemplate.update(sql, map);
				}

				@Test
				public void testDepartmentDao() {
					System.out.println( departmentDao.get(3));
				}
				
				@Test
				public void testEmployeeDao() {
					  System.out.println(employeeDao.get(1));
				}
				
				
				/**
				 * 获取单列值，或做统计查询
				 */
				@Test
				public void testQueryForObject2() {
					String sql = "select  count(id) from employee ";
					long count = jdbcTemplate.queryForObject(sql, Long.class);
					
					System.out.println(count);
				} 
				
				/**
				 * 查到实体类的集合
				 * 注意：调用的不是queryForList 方法
				 */
				@Test
				public void testQueryForList() {
					String sql = "select id ,last_name lastName, email  from employee where id  > ?";
					RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
					List<Employee> list = jdbcTemplate.query(sql, rowMapper,5);
					System.out.println(list);
				
					
				}
				
				
				/**
				 * 从数据库中得到一条记录，实际得到对应的一个对象
				 *注意不是调用这个 queryForObject(String sql, Class<Employee> requiredType, Object... args)  方法！
				 *需要调用 queryForObject(String sql, RowMapper<Employee> rowMapper, Object... args)
				 *
				 *1、其中RowMapper 指定如何去映射结果集的行，常用的实现类为BeanPropertyRowMapper
				 *2、不支持级联属性，JdbcTemplate 到底是一个 JDBC 的小工具，而不是 ORM框架
				 * 
				 */
				@Test
				public void testQueryForObject() {
					String sql = "select id ,last_name lastName, email , dept_id  as  \"department.id \" from employee where id = ?";
					RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
					Employee  employee =  jdbcTemplate.queryForObject(sql, rowMapper, 2);
					System.out.println(employee);
				}
				
				/**
				 * 执行批量更新：批量update，insert，delete
 				 */
				@Test
				public void testBatchUpdate() {
						String sql ="insert into employee (LAST_NAME,EMAIL,DEPT_ID) values( ? , ?, ?)";
						
						List<Object []> batchArgs = new ArrayList<>();
						
						batchArgs.add(new Object[] {"AA","aa@sina.com",1} );
						batchArgs.add(new Object[] {"BB","bb@sina.com",2} );
						batchArgs.add(new Object[] {"CC","cc@sina.com",3} );
						batchArgs.add(new Object[] {"DD","dd@sina.com",3} );
						batchArgs.add(new Object[] {"EE","ee@sina.com",2} );
						
						jdbcTemplate.batchUpdate(sql, batchArgs);
				}
				
				
				/**
				 * 执行 insert，update，delete
				 */
				@Test
				public void testUpdate() {
					 		String sql = "update employee set LAST_NAME = ?  where id = ?";
					 		jdbcTemplate.update(sql, "Rose", 4);
				}
				
				@Test
				public void  testDataSource() throws SQLException {
					DataSource dataSource = context.getBean(DataSource.class);
					System.out.println(dataSource.getConnection());
				}
}
