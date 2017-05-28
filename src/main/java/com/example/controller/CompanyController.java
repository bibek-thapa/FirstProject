/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.controller;

import com.example.data.Company;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.example.DAOService.CompanyDAO;

@Controller
@RequestMapping(value = "/company")
public class CompanyController {

    @Autowired
    private CompanyDAO companyDAO;

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public ModelAndView form() {
        ModelAndView mav = new ModelAndView("/admin/company/company-form");
        return mav;

    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView create(@ModelAttribute Company company, final RedirectAttributes redirectAttributes) {
        ModelAndView mav = new ModelAndView();
        companyDAO.insert(company);
        String message = "Company named " + company.getCompanyName() + " succesfully created";
        mav.setViewName("redirect:/company/list");
        redirectAttributes.addFlashAttribute("message", message);
        return mav;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list() {
        ModelAndView mav = new ModelAndView("company-list");
        List<Company> companyList = companyDAO.getAll();
        mav.addObject("companyList", companyList);
        return mav;

    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editcompany(@PathVariable("id") Long id) {
        ModelAndView mav = new ModelAndView("admin/company/company-update");
        Company company = companyDAO.getById(id);
       // mav.addObject("company", company);
        return mav;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public ModelAndView editcompany(@PathVariable("id") Long id, @ModelAttribute Company company, final RedirectAttributes redirectAttributes) {
        ModelAndView mav = new ModelAndView();
        companyDAO.update(company, id);
        String message = "Company " + company.getCompanyName() + " is succesfully updated";
        redirectAttributes.addFlashAttribute("message", message);
        mav.setViewName("redirect:/company/list");
        return mav;

    }
    
    @RequestMapping(value="/delete/{id}",method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable ("id")Long id)
    {
        ModelAndView mav = new ModelAndView();
        companyDAO.delete(id);
        mav.setViewName("redirect:/company/list");
        return mav;
    
    }
}
