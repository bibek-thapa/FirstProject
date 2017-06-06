
package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("personName")
@RequestMapping(value="person")
public class ShopController {
    
    @RequestMapping(value="/index")
    public ModelAndView index(ModelAndView mav,@RequestParam String personName)
    {
        mav.addObject("personName", personName);
        mav.setViewName("sessiontest");
        return mav;
    
    }
    
    
   
    
   
    
}
