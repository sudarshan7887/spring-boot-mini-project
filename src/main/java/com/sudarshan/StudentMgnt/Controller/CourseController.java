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
import com.sudarshan.StudentMgnt.Repository.CourseRepository;
import com.sudarshan.StudentMgnt.Service.CourseService;

@Controller
@RequestMapping("/Course")
public class CourseController
{
	@Autowired
	private CourseService service;

	
	
	@GetMapping("/addCourse")
	public String add(Model model) {
		List<Course>listcourse = service.ListAll();
		model.addAttribute("listCourse",listcourse);
		model.addAttribute("Course",new Course());
		
		return "addCourse";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveCourse(@ModelAttribute("course") Course course)
	{
		
        service.save(course);
        return "redirect:/Course";
       
    }

	
	 @RequestMapping("/edit/{id}")
	    public ModelAndView showEditCourse(@PathVariable(name = "id") int id)
	 {
	        ModelAndView mav = new ModelAndView("addCourse");
	        Course course = service.get(id);
	        mav.addObject("Course", course);
	        return mav;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteCourse(@PathVariable(name = "id")long id) 
	{	
		service.delete(id);		
		return "redirect:/Course";
		
	}
	
	
}


