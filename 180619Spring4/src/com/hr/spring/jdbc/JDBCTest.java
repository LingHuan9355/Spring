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
 * @Date : 2018��6��27�� ����11:35:15
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
				 * ʹ�þ�������ʱ����ʹ�ã�update(String sql, SqlParameterSource paramSource) �������и��²���
				 *1.SQL ����еĲ������������һ��
				 *2.ʹ�� SqlParameterSource �� BeanPropertySqlParameterSource ʵ������Ϊ������
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
				 * ʹ�þ�������������Ϊ���������֣�
				 * 1.�ŵ㣺���ж��������������ȥ��Ӧλ�ã�ֱ�Ӷ���������֣�����ά��
				 * 2.ȱ�㣺��Ϊ�鷳
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
				 * ��ȡ����ֵ������ͳ�Ʋ�ѯ
				 */
				@Test
				public void testQueryForObject2() {
					String sql = "select  count(id) from employee ";
					long count = jdbcTemplate.queryForObject(sql, Long.class);
					
					System.out.println(count);
				} 
				
				/**
				 * �鵽ʵ����ļ���
				 * ע�⣺���õĲ���queryForList ����
				 */
				@Test
				public void testQueryForList() {
					String sql = "select id ,last_name lastName, email  from employee where id  > ?";
					RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
					List<Employee> list = jdbcTemplate.query(sql, rowMapper,5);
					System.out.println(list);
				
					
				}
				
				
				/**
				 * �����ݿ��еõ�һ����¼��ʵ�ʵõ���Ӧ��һ������
				 *ע�ⲻ�ǵ������ queryForObject(String sql, Class<Employee> requiredType, Object... args)  ������
				 *��Ҫ���� queryForObject(String sql, RowMapper<Employee> rowMapper, Object... args)
				 *
				 *1������RowMapper ָ�����ȥӳ���������У����õ�ʵ����ΪBeanPropertyRowMapper
				 *2����֧�ּ������ԣ�JdbcTemplate ������һ�� JDBC ��С���ߣ������� ORM���
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
				 * ִ���������£�����update��insert��delete
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
				 * ִ�� insert��update��delete
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
