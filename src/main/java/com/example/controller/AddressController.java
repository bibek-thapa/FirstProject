
package com.example.controller;

import com.example.DAOService.AddressDAOService;
import com.example.data.Address;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value="/address")
public class AddressController {
    
    @Autowired
    private AddressDAOService addressService;
    
   @RequestMapping(value="/form")
    public ModelAndView homePage()
    {
        ModelAndView mav = new ModelAndView("/admin/address/addresscreate");
        return mav;
    }
    
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public ModelAndView create(@ModelAttribute Address address,final RedirectAttributes redirectAttributes)
    {
        ModelAndView mav = new ModelAndView();
        addressService.insert(address);
        mav.setViewName("redirect:/address/form");
        return mav;
      }
    
    @RequestMapping(value = "/list")
    public ModelAndView list()
    {
        ModelAndView mav = new ModelAndView("/admin/address/addressList");
        List<Address> addressList = addressService.getAll();
        mav.addObject("addressList", addressList);
        return mav;     
    }
    
}
