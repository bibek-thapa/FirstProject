package com.example.controller;

import com.example.DAOService.OrderDAO;
import com.example.DAOService.ProductDAO;
import com.example.data.Customer;
import com.example.data.Order;
import com.example.data.Product;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@SessionAttributes("thought")

@RequestMapping(value = "/cart")
public class CartController {

    @Autowired
    ProductDAO productDAO;

    @Autowired
    OrderDAO orderDAO;

    List<Object> cartList = new ArrayList<Object>();

    Logger logger = Logger.getLogger("CartController.class");

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView add(@RequestParam("id") Long id, HttpServletRequest request) {

        ModelAndView mav = new ModelAndView();
        cartList.add(productDAO.getById(id));
        mav.addObject("thought", cartList);
        mav.addObject("orderQuantity", request.getAttribute("orderQuantity"));
        logger.info(cartList);
        mav.setViewName("redirect:/cart/list");
        return mav;
    }

    @RequestMapping(value = "/remove")
    public ModelAndView remove(@RequestParam("id") int id) {
        ModelAndView mav = new ModelAndView();
        cartList.remove(cartList.get(id));
        mav.setViewName("redirect:/cart/list");
        return mav;
    }

    @RequestMapping(value = "/list")
    public ModelAndView list(@ModelAttribute("cartForm") Customer customer) {
        ModelAndView mav = new ModelAndView();
     //   logger.info("productQuantity");
        mav.setViewName("/admin/cartview");
        return mav;
    }

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public ModelAndView order(HttpServletRequest request,SessionStatus status, @Valid @ModelAttribute("cartForm") Customer customer, BindingResult result) {
        ModelAndView mav = new ModelAndView();
        Order order = new Order();
       
        if (result.hasErrors()) {
            logger.info(result);
            logger.info("Form has errors");
            mav.setViewName("admin/cartview");
        }
        else {
            logger.info("----------------------------------------------------Start of for loop");
            
            for(int i =0 ; i < cartList.size();i++){
                Product product = (Product)cartList.get(i);
                logger.info(cartList.get(i));
                logger.info(customer.toString());
                logger.info(i);
                order.setOrderQuantity(12L);
                order.setCustomer(customer);
                order.setProduct(product);
                logger.info("Before the insert");
                orderDAO.insert(order);
                logger.info("After the insert");
                
            }
            
           logger.info("----------------------------------------------------End of for loop");

               
            status.setComplete();
            cartList.clear();
            logger.info("No error");
            mav.setViewName("redirect:/");
    }     
        return mav;
    }

    @RequestMapping(value = "/sessiontest")
    public ModelAndView sessiontest(SessionStatus status, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        logger.info(request.getAttribute("personName"));
        status.setComplete();
        cartList.clear();
        mav.setViewName("/sessiontest");
        return mav;

    }

    @RequestMapping(value = "/sessiontestpost", method = RequestMethod.POST)
    public ModelAndView sessiontestpost(@RequestParam String personName) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("thought", personName);
        mav.setViewName("redirect:sessiontest");
        return mav;

    }

}
