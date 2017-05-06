package com.example.controller;

import com.example.DAOService.CompanyService;
import com.example.data.Company;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class HomeController {

        @Autowired
        private CompanyService companyService;
    
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String index(Model model){
            List<Company> companyList = companyService.getAll();
            model.addAttribute("companyList", companyList);
		return "index";
	}
    
	@RequestMapping(value="/home", method = RequestMethod.GET)
	public String home(){
		return "index1";
	}
        
        @RequestMapping(value = "/login" , method = RequestMethod.GET)
        public String login()
        {
            return "login";
        
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
