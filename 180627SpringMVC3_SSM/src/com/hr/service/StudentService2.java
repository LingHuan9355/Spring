package com.hr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hr.dao.StudentMapper;
import com.hr.entity.Student;


@Service("StudentService2")
public class StudentService2 implements IStudentService {
	
		@Autowired	
		private  StudentMapper studentDao;
		
		/* (non-Javadoc)
		 * @see com.hr.service.IStudentService#addStudent(com.hr.entity.Student)
		 */
		@Override
		public int addStudent(Student student) throws Exception {
			System.out.println("StudentService2...");
			return studentDao.insert(student);
		}

}
