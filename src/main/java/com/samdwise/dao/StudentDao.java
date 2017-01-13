package com.samdwise.dao;

import java.util.List;

import com.samdwise.model.Student;

public interface StudentDao {
	public void add(Student stu);
	public void delete(int stuId);
	public void edit(Student stu);
	public Student getStudent(int stuId);
	public List getStudentList();

}
