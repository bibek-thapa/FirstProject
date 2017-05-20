/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.controller;

import com.example.DAOService.EmployeeDAOService;
import com.example.data.Employee;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value="/employee")
public class EmployeeController {
    
    @Autowired
    private EmployeeDAOService employeeDAOService;
    
    
    
    @RequestMapping(value="/form")
    public ModelAndView form()
    {
        ModelAndView mav = new ModelAndView("/admin/employee/employee-form");
        return mav;
    
    }
    
    
     @RequestMapping(value="/create",method = RequestMethod.POST)
    public ModelAndView create(@ModelAttribute Employee employee , final RedirectAttributes redirectAttributes)
    {
        ModelAndView mav = new ModelAndView();
        employeeDAOService.insert(employee);
        
        String message = "Employee "+ employee.getFirstName() + "was successfully created";
        mav.setViewName("redirect:/employee/list");
        redirectAttributes.addFlashAttribute("message", message);
        return mav;
    
    }
    
    
    @RequestMapping(value="/list",method = RequestMethod.GET)
    public ModelAndView list()
    {
        ModelAndView mav = new ModelAndView("/admin/employee/employee-list");
        List<Employee> employeeList = employeeDAOService.getAll();
        mav.addObject("employeeList", employeeList);
        return mav;
        
    }
    
}
