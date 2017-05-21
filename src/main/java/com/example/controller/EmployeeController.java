/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.controller;

import com.example.data.Company;
import com.example.data.Employee;
import com.example.data.Employee;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.example.DAOService.EmployeeDAO;
import com.example.DAOService.EmployeeSalaryDAO;
import com.example.data.EmployeeSalary;

@Controller
@RequestMapping(value="/employee")
public class EmployeeController {
    
    @Autowired
    private EmployeeDAO employeeDAO;
//    
//    @Autowired
//    private EmployeeSalaryDAO employeeSalaryDAO;
    
    
    
    @RequestMapping(value="/form")
    public ModelAndView form()
    {
        ModelAndView mav = new ModelAndView("/admin/employee/employee-form");
//        List<EmployeeSalary> employeeSalaryList = employeeSalaryDAO.getAll();
//        mav.addObject("employeeSalaryList",employeeSalaryList );
      return mav;
    
    }
    
    
     @RequestMapping(value="/create",method = RequestMethod.POST)
    public ModelAndView create(@ModelAttribute Employee employee , final RedirectAttributes redirectAttributes)
    {
        ModelAndView mav = new ModelAndView();
        employeeDAO.insert(employee);
        
        String message = "Employee "+ employee.getFirstName() + "was successfully created";
        mav.setViewName("redirect:/employee/list");
        redirectAttributes.addFlashAttribute("message", message);
        return mav;
    
    }
    
    
    @RequestMapping(value="/list",method = RequestMethod.GET)
    public ModelAndView list()
    {
        ModelAndView mav = new ModelAndView("/admin/employee/employee-list");
        List<Employee> employeeList = employeeDAO.getAll();
        mav.addObject("employeeList", employeeList);
        return mav;
        
    }
    
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editById(@PathVariable("id") Long id) {
        ModelAndView mav = new ModelAndView("/admin/employee/employee-update");
        Employee employee = employeeDAO.getById(id);
        List<Employee> employeeList = employeeDAO.getAll();
        mav.addObject("employee", employee);
        mav.addObject("employeeList", employeeList);
        return mav;

    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public ModelAndView editById(@PathVariable("id") Long id,@ModelAttribute Employee employee,final RedirectAttributes redirectAttributes) {
        ModelAndView mav = new ModelAndView();
        employeeDAO.update(employee,id);
        
        String message = "Employee " + employee.getFirstName() + " is updated";
        redirectAttributes.addFlashAttribute("message", message);
        mav.setViewName("redirect:/employee/list");
        
        return mav;

    }
    
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id")Long id)
    {
        ModelAndView mav = new ModelAndView();
        employeeDAO.delete(id);
        mav.setViewName("redirect:/employee/list");
        return mav;
    
    }
    
    

    
}
