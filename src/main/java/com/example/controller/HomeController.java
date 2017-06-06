package com.example.controller;

import com.example.data.Company;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.DAOService.CompanyDAO;
import com.example.DAOService.ProductDAO;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class HomeController {

       
        @Autowired
        ProductDAO  productDAO;
    
	@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView index(ModelAndView mav){
          mav.addObject("productList", productDAO.getAll());
          mav.setViewName("index");
          return mav;
		
	}
    
	
	
}
