
package com.example.controller;

import com.example.DAOService.ProductDAO;
import com.example.data.Product;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller


public class ImageController {
    
    @Autowired
    ProductDAO productDAO;
    
    Logger logger = Logger.getLogger(ImageController.class);
    
    @RequestMapping("/imageDisplay")
    public void showImage(@RequestParam("id")Long id,HttpServletRequest request,HttpServletResponse response)
    {
        
        Product product = productDAO.getById(id);
        response.setContentType("image/jpeg,image/jpg,image/png");
        try{
        response.getOutputStream().write(product.getProductImage());
        }catch(IOException ioe)
        {
            ioe.printStackTrace();
            logger.info("Product Image of "+ product.getProductName() +" couldnot be loaded" +" with product id" + product.getId());
        }
        finally{
        try{
        response.getOutputStream().close();
        }catch(IOException ioe)
        {
            ioe.printStackTrace();
            logger.info("Output Stream couldnot be closed");
        }
        }
    }
    
}
