package com.hendisantika.customermanager.controller;

import com.hendisantika.customermanager.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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
}