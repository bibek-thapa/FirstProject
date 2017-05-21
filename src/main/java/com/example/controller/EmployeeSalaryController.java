package com.example.controller;

import com.example.data.EmployeeSalary;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.example.DAOService.EmployeeSalaryDAO;

@Controller
@RequestMapping(value = "/employeeSalary")
public class EmployeeSalaryController {

    @Autowired
    private EmployeeSalaryDAO employeeSalaryDAO;

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public ModelAndView form() {
        ModelAndView mav = new ModelAndView("/admin/employee-salary/employeesalary-form");
        return mav;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView create(@ModelAttribute EmployeeSalary employeeSalary, final RedirectAttributes redirectAttributes) {
        ModelAndView mav = new ModelAndView();
        employeeSalaryDAO.insert(employeeSalary);
        mav.setViewName("redirect:/employeeSalary/list");
        return mav;

    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list() {
        ModelAndView mav = new ModelAndView("/admin/employee-salary/employeesalary-list");
        List<EmployeeSalary> employeeSalaryList = employeeSalaryDAO.getAll();
        mav.addObject("employeeSalaryList", employeeSalaryList);
        return mav;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteById(@PathVariable("id") Long id) {
        ModelAndView mav = new ModelAndView();
        employeeSalaryDAO.delete(id);

        mav.setViewName("redirect:/employeeSalary/list");
        return mav;

    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editById(@PathVariable("id") Long id) {
        ModelAndView mav = new ModelAndView("/admin/employee-salary/employeesalary-update");
        EmployeeSalary employeeSalary = employeeSalaryDAO.getById(id);
        mav.addObject("employeeSalary", employeeSalary);
        return mav;

    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public ModelAndView editById(@PathVariable("id") Long id, @ModelAttribute EmployeeSalary employeeSalary, final RedirectAttributes redirectAttributes) {
       ModelAndView mav = new ModelAndView();
        employeeSalaryDAO.update(employeeSalary,id);
        mav.setViewName("redirect:/employeeSalary/list");

        return mav;

    }

}
