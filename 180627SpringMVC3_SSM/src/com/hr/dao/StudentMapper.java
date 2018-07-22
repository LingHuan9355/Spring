package com.hr.dao;

import org.springframework.stereotype.Repository;

import com.hr.entity.Student;

@Repository
public interface StudentMapper {
	
	
    int deleteByPrimaryKey(Integer sid);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer sid);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}