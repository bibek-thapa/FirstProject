/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.controller;

import com.example.DAOService.ProductDAO;
import com.example.data.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/product")
public class ProductController {
    @Autowired
    private ProductDAO productDAO;
    
    @RequestMapping(value="/form")
    public ModelAndView form()
    {
        ModelAndView mav = new ModelAndView("/admin/product/product-form");
        return mav;
    }   
    
    @RequestMapping(value="/list")
    public ModelAndView list()
    {
        ModelAndView mav = new ModelAndView("/admin/product/product-list");
        mav.addObject("productList", productDAO.getAll());
        return mav;
    }
    
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public ModelAndView create(@ModelAttribute Product product)
    {
        ModelAndView mav = new ModelAndView();
        productDAO.insert(product);
        mav.setViewName("redirect:/product/list");
        return mav;
    
    }
    
    @RequestMapping(value="/delete/{id}",method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id")Long id)
    {
        ModelAndView mav = new ModelAndView();
        productDAO.delete(id);
        mav.setViewName("redirect:/product/list");
        return mav;
    }
    
    @RequestMapping(value="/edit/{id}",method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable("id")Long id)
    {
        ModelAndView mav = new ModelAndView("/admin/product/product-update");
        mav.addObject("product", productDAO.getById(id));
        return mav;
    }   
    
    @RequestMapping(value = "/edit/{id}",method = RequestMethod.POST)
    public ModelAndView edit(@PathVariable("id")Long id,@ModelAttribute Product product)
    {
        ModelAndView mav = new ModelAndView();
        productDAO.update(product, id);
        mav.setViewName("redirect:/product/list");
        return mav;
    
    }
    
    }
