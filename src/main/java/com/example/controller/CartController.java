package com.example.controller;

import com.example.DAOService.CustomerDAO;
import com.example.DAOService.OrderDAO;
import com.example.DAOService.OrderDetailDAO;
import com.example.DAOService.ProductDAO;
import com.example.data.Customer;
import com.example.data.Order;
import com.example.data.OrderDetail;
import com.example.data.Product;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    List<Object> cartList = new ArrayList<Object>();

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
        mav.setViewName("redirect:/");
        logger.info("No error");

        return mav;
    }

    @RequestMapping(value = "/sessiontest")
    public ModelAndView sessiontest(SessionStatus status, HttpServletRequest request) {
        for (int i = 0; i < cartList.size(); i++) {

            OrderDetail orderDetail = (OrderDetail) (cartList.get(i));
            logger.info(orderDetail.getProduct().getProductName());
            logger.info(orderDetail.getOrder().getCustomer());
        }
        return null;

    }

    @RequestMapping(value = "/sessiontestpost", method = RequestMethod.POST)
    public ModelAndView sessiontestpost(@RequestParam String personName) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("thought", personName);
        mav.setViewName("redirect:sessiontest");
        return mav;

    }
    
    public void orderDetailHelper()
    {
        Double total = 0.0 ;
        Order order = new Order();
        order.setCustomer(customerDAO.getById(273L));
        orderDAO.insert(order);
        for (int i = 0; i < cartList.size(); i++) {
            logger.info(i);
            OrderDetail orderDetail = new OrderDetail();
            
            orderDetail.setOrder(order);
            orderDetail.setProduct(((OrderDetail) cartList.get(i)).getProduct());
            orderDetail.setOrderQuantity(((OrderDetail) cartList.get(i)).getOrderQuantity());
            logger.info(((OrderDetail) cartList.get(i)).getProduct());
            logger.info("subtotal : "+((OrderDetail) cartList.get(i)).getProduct().getPperUnit()*((OrderDetail) cartList.get(i)).getOrderQuantity());
            total = total  + ((OrderDetail) cartList.get(i)).getOrderQuantity() *(((OrderDetail) cartList.get(i)).getProduct().getPperUnit());
            logger.info("total : " + total);
            orderDetailDAO.insert(orderDetail);

        }
    
    }

}
