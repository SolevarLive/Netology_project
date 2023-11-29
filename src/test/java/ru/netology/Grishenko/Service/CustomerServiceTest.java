package ru.netology.Grishenko.Service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeMethod;
import ru.netology.Grishenko.Domain.Customer;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerServiceTest extends OperatinHistoryApiApplicashenTest {

    static CustomerService customerService = new CustomerService();

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

    @BeforeAll
    public static void setCustomers(){
       customerService.addCustomer(1,"Spring");
       customerService.addCustomer(2,"Boot");
    }

}