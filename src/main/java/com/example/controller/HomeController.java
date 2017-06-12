package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.DAOService.ProductDAO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class HomeController {

       
        @Autowired
        ProductDAO  productDAO;
        
        Logger logger = Logger.getLogger(HomeController.class);
    
	@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView index(ModelAndView mav){
          mav.addObject("productList", productDAO.getAll());
          mav.setViewName("index");
          return mav;
		
	}
        
        @RequestMapping(value="/login")
        public ModelAndView login(HttpServletRequest request,HttpServletResponse response)
        {
            ModelAndView mav = new ModelAndView();
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            
            if(auth == null)
            {
                   
            }
            else
            {
                mav.setViewName("/loginpage");
                
            }
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
            return "redirect:/";
        }
        
        @RequestMapping(value = "/accessdenied" ,method = RequestMethod.GET)
        public String accessDenied()
        {
        
            return "accessDenied";
        
        }
        
        @RequestMapping(value = "/test")
        public String currentUser(HttpSession session)
        {

            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            logger.info(((UserDetails)principal).getUsername());
            logger.info(((UserDetails)principal).getAuthorities());
            logger.info(principal.toString());
            logger.info(SecurityContextHolder.getContext());
            logger.info(session.getId());
            return null;
        }
    
	
	
}
