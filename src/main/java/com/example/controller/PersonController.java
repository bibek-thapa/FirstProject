/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.controller;

import com.example.DAOService.CompanyService;
import com.example.DAOService.PersonDAOService;
import com.example.data.Company;
import com.example.data.Person;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/person")
public class PersonController {

    @Autowired
    private PersonDAOService personDAOService;
    
    @Autowired
    private CompanyService companyService;
    
   

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView create(@ModelAttribute Person person, final RedirectAttributes redirectAttributes) {
        ModelAndView mav = new ModelAndView();
       
        personDAOService.create(person);

        String message = "Person  " + person.getFirstName() + "  was succesfully created";
       
        mav.setViewName("redirect:/");
        redirectAttributes.addFlashAttribute("message", message);
        return mav;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView getAll() {
        ModelAndView mav = new ModelAndView("list");
        List<Person> personList = personDAOService.findAll();

        mav.addObject("personList", personList);
        return mav;

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView getById(final RedirectAttributes redirectAttributes, @PathVariable("id") Long id) {
        ModelAndView mav = new ModelAndView();
        Person person = personDAOService.findById(id);
        String message = "Person " + person.getFirstName() + " is listed";
        mav.setViewName("redirect:/");
        redirectAttributes.addFlashAttribute("message", message);
        return mav;

    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteById(final RedirectAttributes redirectAttributes, @PathVariable("id") Long id) {
        ModelAndView mav = new ModelAndView();
        Person person = personDAOService.delete(id);
        String message = "Person " + person.getFirstName() + " is deleted";
        mav.setViewName("redirect:/person/list");
        redirectAttributes.addFlashAttribute("message", message);
        return mav;

    }
    
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editById(@PathVariable("id") Long id) {
        ModelAndView mav = new ModelAndView("person-update");
        Person person = personDAOService.findById(id);
        List<Company> companyList = companyService.getAll();
        mav.addObject("person", person);
        mav.addObject("companyList", companyList);
        return mav;

    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public ModelAndView editById(@PathVariable("id") Long id,@ModelAttribute Person person,final RedirectAttributes redirectAttributes) {
        ModelAndView mav = new ModelAndView();
        personDAOService.update(person);
        
        String message = "Person " + person.getFirstName() + " is updated";
        redirectAttributes.addFlashAttribute("message", message);
        mav.setViewName("redirect:/person/list");
        
        return mav;

    }

}
