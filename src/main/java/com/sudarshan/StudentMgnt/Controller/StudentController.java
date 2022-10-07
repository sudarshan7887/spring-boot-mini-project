package com.sudarshan.StudentMgnt.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sudarshan.StudentMgnt.Domain.Course;
import com.sudarshan.StudentMgnt.Domain.Student;
import com.sudarshan.StudentMgnt.Service.CourseService;
import com.sudarshan.StudentMgnt.Service.StudentService;

@Controller
@RequestMapping("/student")
 
public class StudentController
{
	@Autowired
    private StudentService service;
	
	@Autowired
	private CourseService services;
 
    @GetMapping("/addstudent")
    public String add(Model model) {
     List<Student> liststudent = service.ListAll();
     List<Course> listCourse = services.ListAll();
    model.addAttribute("listCourse", listCourse);
        model.addAttribute("liststudent", liststudent);
        model.addAttribute("student", new Student());
        return "addstudent";
    }
    
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveStudent(@ModelAttribute("student") Student std)
    {
        service.save(std);
        return "redirect:/student";
    }
    
 
    @RequestMapping("/edit/{id}")
    public ModelAndView showEditStudentPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("addstudent");
        List<Course> listcourse = services.ListAll();
        Student std = service.get(id);
        mav.addObject("student", std);
        return mav;
        
    }
    @RequestMapping("/delete/{id}")
    public String deleteStudentPage(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "student";
    }
 
}
