package com.example.controller;

import com.example.DAOService.CategoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.DAOService.ProductDAO;
import com.example.DAOService.UserDAO;
import com.example.data.Category;
import com.example.data.Product;
import com.example.data.UserDetail;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.SessionScope;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes({"userName"})

public class HomeController {

    @Autowired
    ProductDAO productDAO;

    @Autowired
    UserDAO userDAO;
    
    @Autowired
    CategoryDAO categoryDAO;  
    
    
    
            

    Logger logger = Logger.getLogger(HomeController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index(ModelAndView mav) {
        
        Pageable pageable = new PageRequest(0,6,new Sort(Sort.Direction.ASC,"id"));
        logger.info(productDAO.getByPages(pageable));
        mav.addObject("productList", productDAO.getByPages(pageable));
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        logger.info(auth.getDetails());
        mav.addObject("userName", name);
        mav.setViewName("index");
        return mav;

    }
    
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public ModelAndView index(ModelAndView mav,@RequestParam("page")int pageIndex) {
        
        Pageable pageable = new PageRequest(pageIndex,6,new Sort(Sort.Direction.ASC,"id"));
        logger.info(productDAO.getByPages(pageable));
        mav.addObject("productList", productDAO.getByPages(pageable));
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        logger.info(auth.getDetails());
        mav.addObject("userName", name);
        mav.setViewName("index");
        return mav;

    }

    @RequestMapping(value = "/register")
    public ModelAndView register() {
        ModelAndView mav = new ModelAndView();
        UserDetail user = new UserDetail();
        mav.addObject("userForm", user);
        mav.setViewName("/registerpage");
        return mav;

    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView registerp(@Valid @ModelAttribute("userForm") UserDetail user, BindingResult result) {
        ModelAndView mav = new ModelAndView();
        UserDetail userExists = userDAO.findUserByEmail(user.getEmailAddress());
        logger.info(userExists);

        if (result.hasErrors()) {
            mav.setViewName("/registerpage");
        } else {
            userDAO.saveUser(user);
            mav.addObject("message", user.getUserName() + " registered succesfully");
            mav.setViewName("/registerpage");

        }

        return mav;

    }

    @RequestMapping(value = "/login")
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth == null) {

        } else {
            mav.setViewName("/loginpage");

        }
        return mav;

    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/accessdenied", method = RequestMethod.GET)
    public String accessDenied() {

        return "accessDenied";

    }
    
    
    @RequestMapping(value = "/category/view/{name}")
    public ModelAndView categoryview(@PathVariable("name") String name) {
        ModelAndView mav = new ModelAndView();
        Category category = categoryDAO.getByName(name);
        mav.setViewName("index-category");
        logger.info(productDAO.getByCategory(category));
        mav.addObject("productList", productDAO.getByCategory(category));
        return mav;

    }

    @RequestMapping(value = "/test")
    public String currentUser(HttpSession session, SessionScope scope, SessionCreationPolicy creationPolicy) {

        logger.info(session.getAttribute("thought"));
        logger.info(session.getId());

        logger.info(session.getCreationTime());
        logger.info(session.getServletContext());
        logger.info(session.isNew());
        logger.info(session.getMaxInactiveInterval());

        //Session scope
        logger.info(scope.getConversationId());
        //Session registry
        logger.info(creationPolicy.name());

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        logger.info(((UserDetails) principal));

        logger.info(((UserDetails) principal).getAuthorities());
        logger.info(principal.toString());
        logger.info(SecurityContextHolder.getContext());
        logger.info(session.getId());

        return null;
    }

}
