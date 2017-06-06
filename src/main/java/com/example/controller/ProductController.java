/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.controller;

import com.example.DAOService.ProductDAO;
import com.example.data.Product;
import java.io.IOException;
import javax.servlet.annotation.MultipartConfig;
import javax.validation.Valid;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/product")

public class ProductController  {
    @Autowired
    private ProductDAO productDAO;
    
     private Logger logger = Logger.getLogger(ProductController.class);
    
    @RequestMapping(value="/create")
    public ModelAndView create()
    {   Product product = new Product();
        ModelAndView mav = new ModelAndView("/admin/product/product-form");
        mav.addObject("productForm",product);
        logger.info("In the Create part of the Product Controller");
        return mav;
    }   
    
    @RequestMapping(value = "/create",method = RequestMethod.POST)
   
    public ModelAndView create(@Valid @ModelAttribute("productForm")Product product,BindingResult result,@RequestPart("productImage")MultipartFile productImage ) 
    {
        ModelAndView mav = new ModelAndView();
        if(result.hasErrors())
        {
            
       mav.setViewName("/admin/product/product-form");
       
        }
        else{
           
            try{
            byte[] productbytes= productImage.getBytes();
            product.setProductImage(productbytes);
            }catch(IOException ioe)
            {
                logger.error("Image cannot be loaded");
                
            }
        productDAO.insert(product);
        
       logger.info("Product named " + product.getProductName() + " is created");
        mav.setViewName("redirect:/product/list");
        
        }
        return mav;
    
    }
    
    @RequestMapping(value="/list")
    public ModelAndView list()
    {
        ModelAndView mav = new ModelAndView("/admin/product/product-list");
        mav.addObject("productList", productDAO.getAll());
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
    
    @RequestMapping(value="/view",method = RequestMethod.GET)
    public ModelAndView view(ModelAndView mav,@RequestParam("id")Long id)
    {
        mav.setViewName("/admin/product/product-view");
        mav.addObject("product", productDAO.getById(id));
        return mav;
    
    }
    
    }
