
package com.example.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CartController {
    
    private List<Object> cartList = new ArrayList<Object>();
    
    @RequestMapping(value="/add")
    public ModelAndView add(ModelAndView mav)
    {
        
    
        return mav;
    }
    
}
