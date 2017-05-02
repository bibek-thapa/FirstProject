package com.example.controller;

import com.example.DAOService.CompanyService;
import com.example.data.Company;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
		return "person-new";
	}
    
	@RequestMapping(value="/home", method = RequestMethod.GET)
	public String home(){
		return "index";
	}
	
}
