package com.sudarshan.StudentMgnt.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sudarshan.StudentMgnt.Domain.Course;
import com.sudarshan.StudentMgnt.Domain.StudentDAO;
import com.sudarshan.StudentMgnt.Repository.StudentRepository;
import com.sudarshan.StudentMgnt.Service.CourseService;
import com.sudarshan.StudentMgnt.Service.StudentService;

@Controller
@RequestMapping("/")
public class indexController 
{
	@Autowired
	private CourseService service;
	
	@Autowired
	private StudentService services;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@RequestMapping(value = "/student",method = RequestMethod.GET)
	public String viewStudentPage(Model model) 
	{
		List<StudentDAO> li = new ArrayList<>();
		for(Object[] obj : studentRepository.findStudent()){
			StudentDAO student = new StudentDAO();
			student.setId(Long.parseLong(String.valueOf(obj[0])));
			student.setStname((String)obj[1]);
			student.setCname((String) obj[2]);
			li.add(student);
		}
		model.addAttribute("liststudent",li);
		return "student";
	}
	
	@RequestMapping(value = "/index",method=RequestMethod.GET)
	public String index() {
		return "index";
	}
	
			@RequestMapping(value = "/Course",method = RequestMethod.GET)
			public String viewHomePage(Model model) {
				List<Course>listcourse = service.ListAll();
				model.addAttribute("listCourse",listcourse);
				System.out.println("Data Stored in database....");
				
				return "Course";
			}
}
