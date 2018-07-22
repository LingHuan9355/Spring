package com.hr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hr.dao.StudentMapper;
import com.hr.entity.Student;

/**
 * 
 * @Name  : StudentService
 * @Author : LH
 * @Date : 2018年7月22日 下午5:06:31
 * @Version : V1.0
 * 
 * @Description :
 */
@Service("StudentService")
public class StudentService implements IStudentService {
	
		@Autowired	
		private  StudentMapper studentDao;
		
		/* (non-Javadoc)
		 * @see com.hr.service.IStudentService#addStudent(com.hr.entity.Student)
		 */
		@Override
		public int addStudent(Student student) throws Exception {
			return studentDao.insert(student);
		}

}
