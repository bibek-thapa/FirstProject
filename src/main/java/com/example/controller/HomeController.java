package com.example.controller;

import com.example.data.Company;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.DAOService.CompanyDAO;

@Controller

public class HomeController {

        @Autowired
        private CompanyDAO companyDAO;
    
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String index(Model model){
            List<Company> companyList = companyDAO.getAll();
            model.addAttribute("companyList", companyList);
		return "index";
	}
    
	@RequestMapping(value="/home", method = RequestMethod.GET)
	public String home(){
		return "index";
	}
	
}
