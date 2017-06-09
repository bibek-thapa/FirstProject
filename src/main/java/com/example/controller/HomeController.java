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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.omg.CORBA.MARSHAL;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
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
        
        @RequestMapping(value="/login")
        public ModelAndView login()
        {
            ModelAndView mav = new ModelAndView();
            mav.setViewName("/loginpage");
            return mav;
        
        }
        
        @RequestMapping(value = "/logout" ,method = RequestMethod.GET)
        public String logout(HttpServletRequest request , HttpServletResponse response)
        {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            if(auth != null)
            {
                new SecurityContextLogoutHandler().logout(request, response, auth);
            }
            return "redirect:login?logout";
        }
        
        @RequestMapping(value = "/accessdenied" ,method = RequestMethod.GET)
        public String accessDenied()
        {
        
            return "accessDenied";
        
        }
    
	
	
}
