package com.rojalin.studentjpa.controller;


	import java.security.Principal;
import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.web.bind.annotation.ModelAttribute;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.servlet.ModelAndView;

import com.rojalin.studentjpa.model.Student;
import com.rojalin.studentjpa.service.StudentServices;
@Controller
	public class AppController 
	{
		@Autowired
		StudentServices service;
		
		@RequestMapping("/")
	   public String viewHomePage(Model model) 
	   {
		   List<Student>liststudent=service.listall();
		   model.addAttribute("listStudent", liststudent);
		   return "index";
	   }
		
		@RequestMapping("/new")
		public String newStudentPage(Model model) {
			Student student=new Student();
			model.addAttribute(student);
			return "new_student";
		}
		
		@RequestMapping(value="/save",method = RequestMethod.POST)
		public String saveStudent(@ModelAttribute("student")Student student) {
			service.save(student);
			return "redirect:/";
		}
		@RequestMapping("edit/{sid}")
		public ModelAndView showEditStudentpage(@PathVariable(name="sid")Long sid) 
		{
			ModelAndView m= new ModelAndView("edit_student");
			Student student=service.get(sid);
			m.addObject("student", student);
			return m;
		}
		
		@RequestMapping("delete/{sid}")
		public String deleteStudentPage(@PathVariable(name="sid")Long sid) 
		{
			service.delete(sid);
			return "redirect:/";
		}
		@RequestMapping("/403")
		public ModelAndView handleAccessDenied(Principal user) {
			ModelAndView model=new ModelAndView();
			if(user!=null)
				model.addObject("msg","Hi"+user.getName()+"we donot have access to do this ");
			else
				model.addObject("msg","Hi you donot have access to perform the operation.");
			model.setViewName("403");
			return model;
		}
	}

