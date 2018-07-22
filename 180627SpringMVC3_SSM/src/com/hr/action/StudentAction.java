package com.hr.action;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hr.entity.Student;
import com.hr.service.IStudentService;

/**
 * 
 * @Name  : StudentAction
 * @Author : LH
 * @Date : 2018年7月22日 下午5:04:59
 * @Version : V1.0
 * 
 * @Description :
 */

@Controller
@RequestMapping("/student")
public class StudentAction {

	
		//@Autowired
		//@Resource(name="StudentService2")
		@Autowired
		@Qualifier("StudentService2")
		private IStudentService studentService;
		
		@RequestMapping("/add")
		public String addStudent() throws Exception {
			Student student = new Student();
			student.setSname("spad");
			student.setAge(25);
			student.setGid(1);
			studentService.addStudent(student);	
			return "success";
		}
}
