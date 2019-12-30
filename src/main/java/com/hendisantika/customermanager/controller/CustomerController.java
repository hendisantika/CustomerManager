package com.hendisantika.customermanager.controller;

import com.hendisantika.customermanager.entity.Customer;
import com.hendisantika.customermanager.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : CustomerManager
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 31/12/19
 * Time: 06.58
 */
@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // handler methods will go here...

    @RequestMapping("/")
    public ModelAndView home() {
        List<Customer> listCustomer = customerService.listAll();
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("listCustomer", listCustomer);
        return mav;
    }
}