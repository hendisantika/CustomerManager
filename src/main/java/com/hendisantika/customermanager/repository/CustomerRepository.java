package com.hendisantika.customermanager.repository;

import com.hendisantika.customermanager.entity.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

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
    @Query(value = "SELECT c FROM Customer c WHERE c.name LIKE '%' || :keyword || '%'"
            + " OR c.email LIKE '%' || :keyword || '%'"
            + " OR c.address LIKE '%' || :keyword || '%'")
    List<Customer> search(@Param("keyword") String keyword);
}