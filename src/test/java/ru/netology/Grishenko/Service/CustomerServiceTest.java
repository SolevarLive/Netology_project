package ru.netology.Grishenko.Service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.netology.Grishenko.Domain.Customer;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerServiceTest extends OperatinHistoryApiApplicashenTest {
    @Autowired
    CustomerService customerService;

    @Test
    public void getCustomersTest(){
        List<Customer> customers = customerService.getCustomers();
        Customer customer1 = customers.get(0);
        Customer customer2 = customers.get(1);
        assertEquals(1,customer1.getId());
        assertEquals("Spring",customer1.getName());
       assertEquals(2,customer2.getId());
       assertEquals("Boot",customer2.getName());
        assertEquals(2,customers.size());
    }
}