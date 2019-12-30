package com.hendisantika.customermanager.repository;

import com.hendisantika.customermanager.entity.Customer;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by IntelliJ IDEA.
 * Project : CustomerManager
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 31/12/19
 * Time: 06.56
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {

}