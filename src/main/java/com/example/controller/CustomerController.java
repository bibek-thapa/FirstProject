package com.example.controller;

import com.example.data.Customer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.example.DAOService.CustomerDAO;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {

    @Autowired
    private CustomerDAO customerDAO;

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView create() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("customerForm",new Customer());
        mav.setViewName("/admin/customer/customer-form");
        return mav;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView create( @Valid @ModelAttribute("customerForm")  Customer customer, BindingResult result) {

        ModelAndView mav = new ModelAndView();

        if (result.hasErrors()) {

            mav.setViewName("/admin/customer/customer-form");
        } else {
            customerDAO.insert(customer);

            mav.setViewName("redirect:/customer/list");
        }
        return mav;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView getAll() {
        ModelAndView mav = new ModelAndView("/admin/customer/customer-list");
        List<Customer> customerList = customerDAO.getAll();
        mav.addObject("customerList", customerList);
        return mav;

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView getById(final RedirectAttributes redirectAttributes, @PathVariable("id") Long id) {
        ModelAndView mav = new ModelAndView();
        Customer customer = customerDAO.getById(id);
        String message = "Customer " + customer.getFirstName() + " is listed";
        mav.setViewName("redirect:/");
        redirectAttributes.addFlashAttribute("message", message);
        return mav;

    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteById(final RedirectAttributes redirectAttributes, @PathVariable("id") Long id) {
        ModelAndView mav = new ModelAndView();
        Customer customer = customerDAO.delete(id);
        String message = "Customer " + customer.getFirstName() + " is deleted";
        mav.setViewName("redirect:/customer/list");
        redirectAttributes.addFlashAttribute("message", message);
        return mav;

    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editById(@PathVariable("id") Long id) {
        ModelAndView mav = new ModelAndView("/admin/customer/customer-update");
        Customer customer = customerDAO.getById(id);
        mav.addObject("customerForm", customer);
        return mav;

    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public ModelAndView editById(@PathVariable("id") Long id, @ModelAttribute("customerForm") Customer customer, final RedirectAttributes redirectAttributes) {
        ModelAndView mav = new ModelAndView();
        customerDAO.update(customer, id);

        String message = "Customer " + customer.getFirstName() + " is updated";
        redirectAttributes.addFlashAttribute("message", message);
        mav.setViewName("redirect:/customer/list");

        return mav;

    }

}
