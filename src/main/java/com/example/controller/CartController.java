package com.example.controller;

import com.example.DAOService.CustomerDAO;
import com.example.DAOService.OrderDAO;
import com.example.DAOService.OrderDetailDAO;
import com.example.DAOService.ProductDAO;
import com.example.DAOService.UserDAO;
import com.example.data.Customer;
import com.example.data.Order;
import com.example.data.OrderDetail;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes({"thought"})

@RequestMapping(value = "/cart")
public class CartController {

    @Autowired
    ProductDAO productDAO;

    @Autowired
    OrderDetailDAO orderDetailDAO;

    @Autowired
    OrderDAO orderDAO;

    @Autowired
    CustomerDAO customerDAO;

    @Autowired
    UserDAO userDAO;

    List<OrderDetail> cartList = new ArrayList<OrderDetail>();

    Logger logger = Logger.getLogger("CartController.class");

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView create(@RequestParam("id") Long id, @RequestParam("orderQuantity") Long orderQty) {

        ModelAndView mav = new ModelAndView();
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setProduct(productDAO.getById(id));
        orderDetail.setOrderQuantity(orderQty);
        cartList.add(orderDetail);
        mav.addObject("thought", cartList);

        logger.info(cartList);
        mav.setViewName("redirect:/cart/list");
        return mav;
    }

    @RequestMapping(value = "/remove")
    public ModelAndView remove(@RequestParam("id") int id, SessionStatus status, HttpSession session) {
        ModelAndView mav = new ModelAndView();
        logger.info("CartList:" + cartList);
        logger.info("CartList:" + session.getAttribute("thought"));

        cartList.remove(cartList.get(id));
        mav.setViewName("redirect:/cart/list");

        return mav;
    }

    @RequestMapping(value = "/list")
    public ModelAndView list(@ModelAttribute("cartForm") Customer customer) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/admin/cartview");
        return mav;
    }

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public ModelAndView order(HttpServletRequest request, SessionStatus status) {
        ModelAndView mav = new ModelAndView();
        orderDetailHelper();
        status.setComplete();
        cartList.clear();
        mav.setViewName("redirect:/?ordersuccess");
        logger.info("No error");

        return mav;
    }

    
    

    public void orderDetailHelper() {
        Double total = 0.0;
        
        Order order = new Order();
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        order.setUser(userDAO.findUserByEmail(((UserDetails) principal).getUsername()));
        orderDAO.insert(order);
        for (int i = 0; i < cartList.size(); i++) {
            logger.info(i);
            

            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrder(order);
            orderDetail.setProduct((cartList.get(i)).getProduct());
            orderDetail.setOrderQuantity((cartList.get(i)).getOrderQuantity());
            logger.info(( cartList.get(i)).getProduct());
            logger.info("subtotal : " + ( cartList.get(i)).getProduct().getPperUnit() * (cartList.get(i)).getOrderQuantity());
            total = total + (cartList.get(i)).getOrderQuantity() * (( cartList.get(i)).getProduct().getPperUnit());
            logger.info("total : " + total);
            orderDetailDAO.insert(orderDetail);

        }

    }

}
