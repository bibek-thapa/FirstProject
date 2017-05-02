/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.controller;

import com.example.DAOService.CompanyService;
import com.example.data.Company;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/company")
public class CompanyController {
    
    @Autowired
    private CompanyService companyService;
    
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public ModelAndView create(@ModelAttribute Company company,final RedirectAttributes redirectAttributes)
    {
        ModelAndView mav = new ModelAndView();
        companyService.insert(company);
        String message = "Company named " + company.getCompanyName()+" succesfully created";
        mav.setViewName("redirect:/");
        redirectAttributes.addFlashAttribute("message",message);
        return mav;
    }
    
    @RequestMapping(value = "/list" , method = RequestMethod.GET)
    public ModelAndView list()
    {
        ModelAndView mav = new ModelAndView("company-list");
      List<Company> companyList =   companyService.getAll();
     mav.addObject("companyList", companyList);
     return mav;
    
    }
    
    
}
