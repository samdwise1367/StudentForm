package com.samdwise.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.samdwise.dao.StudentDao;
import com.samdwise.model.Student;

@Repository
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(Student stu) {
		session.getCurrentSession().save(stu);

	}

	@Override
	public void delete(int stuId) {
		
		session.getCurrentSession().delete(getStudent(stuId));

	}

	@Override
	public void edit(Student stu) {
		session.getCurrentSession().update(stu);

	}

	@Override
	public Student getStudent(int stuId) {
		// TODO Auto-generated method stub
		return (Student)session.getCurrentSession().get(Student.class, stuId);
	}

	@Override
	public List getStudentList() {
		return session.getCurrentSession().createQuery("from Student").list();
	}

}
