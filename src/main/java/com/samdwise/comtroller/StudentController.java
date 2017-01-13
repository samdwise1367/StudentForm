package com.samdwise.comtroller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.samdwise.model.Student;
import com.samdwise.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	private StudentService studService;

	@RequestMapping("/index")
	public String setupForm(Map<String, Object> map){
		Student stud = new Student();
		map.put("student", stud);
		map.put("studentList", studService.getStudentList());
		return "student";
		
	}
	
	@RequestMapping(value="/student.do",method=RequestMethod.POST)
	public String doActions(@ModelAttribute Student stud, BindingResult res,
			@RequestParam String action,Map<String, Object> map){
		
		Student stuResult = new Student();
		switch(action.toLowerCase()){
		case "add":
			studService.add(stud);
			stuResult = stud;
			break;
		case "edit":
			studService.edit(stud);
			stuResult = stud;
			break;
		case "delete":
			studService.delete(stud.getUserId());
			stuResult = stud;
			break;
		case "search":
			Student serchStudent = studService.getStudent(stud.getUserId());
			stuResult = serchStudent!=null ? serchStudent : new Student();
			break;
		}
		
		map.put("student", stuResult);
		map.put("studentList", studService.getStudentList());
		return "student";
	}
}
