/**
 * 
 */
package com.samdwise.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.samdwise.dao.StudentDao;
import com.samdwise.model.Student;
import com.samdwise.service.StudentService;

/**
 * @author samdwise
 *
 */

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDao stuDao;
	
	@Transactional
	public void add(Student stu) {
		stuDao.add(stu);

	}

	@Transactional
	public void delete(int stuId) {
		stuDao.delete(stuId);

	}

	@Transactional
	public void edit(Student stu) {
		stuDao.edit(stu);

	}

	@Transactional
	public Student getStudent(int stuId) {
		return stuDao.getStudent(stuId);
	}

	@Transactional
	public List getStudentList() {
		return stuDao.getStudentList();
	}

}
