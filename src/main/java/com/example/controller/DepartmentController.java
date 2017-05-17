package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/company/department")
public class DepartmentController {
    
    
    @RequestMapping(value = "/form",method = RequestMethod.GET)
    public ModelAndView register()
    {
        ModelAndView mav = new ModelAndView("/admin/department/departmentcreate");
        return mav;
        
    }
    
    
    
    
}
