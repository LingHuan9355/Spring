package com.hr.spring.jdbc;

/**
 * 
 * @Name  : Employee
 * @Author : LH
 * @Date : 2018年6月28日 上午12:01:32
 * @Version : V1.0
 * 
 * @Description :
 */
public class Employee {
				
					
					private Integer id;
					private String lastName;
					private String email;
			
					private  Integer deptId;

					
					public Integer getId() {
						return id;
					}

					public void setId(Integer id) {
						this.id = id;
					}

					public String getLastName() {
						return lastName;
					}

					public void setLastName(String lastName) {
						this.lastName = lastName;
					}

					public String getEmail() {
						return email;
					}

					public void setEmail(String email) {
						this.email = email;
					}

					public Integer getDeptId() {
						return deptId;
					}

					public void setDeptId(Integer deptId) {
						this.deptId = deptId;
					}

					@Override
					public String toString() {
						return "Employee [id=" + id + ", lastName=" + lastName + ", email=" + email + ", deptId="
								+ deptId + "]";
					}

					
					
					
}
