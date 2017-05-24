package com.example.controller;

import com.example.DAOService.CustomerDAO;
import com.example.DAOService.OrderDAO;
import com.example.data.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/order")
public class OrderController {
    
    @Autowired
    private OrderDAO orderDAO;
    
    @Autowired
    private CustomerDAO customerDAO;
    
    
    
    @RequestMapping(value = "/form")
    public ModelAndView form() {
        ModelAndView mav = new ModelAndView("/admin/order/order-form");
        mav.addObject("customerList", customerDAO.getAll());
        return mav;
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView create(@ModelAttribute Order order) {
        ModelAndView mav = new ModelAndView();
        orderDAO.insert(order);
        mav.setViewName("redirect:/order/list");
        return mav;
        
    }
    
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list() {
        ModelAndView mav = new ModelAndView("/admin/order/order-list");
        mav.addObject("orderList", orderDAO.getAll());
        return mav;
        
    }
    
    @RequestMapping(value = "/edit/{id}",method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable("id")Long id)
    {
        ModelAndView mav = new ModelAndView("/admin/order/order-update");
        Order order = orderDAO.getById(id);
        mav.addObject("order", order);
        return mav;
    }
    
    @RequestMapping(value="/edit/{id}",method = RequestMethod.POST)
    public ModelAndView edit(@PathVariable("id")Long id , @ModelAttribute Order order)
    {
        ModelAndView mav = new ModelAndView();
        orderDAO.update(order, id);
        mav.setViewName("redirect:/order/list");
        return mav;
    }
    
    @RequestMapping(value="/delete/{id}")
    public ModelAndView delete(@PathVariable("id")Long id)
    {
        ModelAndView mav = new ModelAndView();
        orderDAO.delete(id);
        mav.setViewName("redirect:/order/list");
        return mav;
    
    
    }
    
}
