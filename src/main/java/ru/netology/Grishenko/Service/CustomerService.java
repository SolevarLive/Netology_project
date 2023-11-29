package ru.netology.Grishenko.Service;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ru.netology.Grishenko.Domain.Customer;


import java.util.ArrayList;
import java.util.List;


@Component
@AllArgsConstructor
public class CustomerService {
    private final List<Customer> storage = new ArrayList<>();

    public void addCustomer(int id, String name){
        Customer client = new Customer(id, name);
        storage.add(client);
    }

    public List<Customer> getCustomers(){
        return storage;
    }

    @PostConstruct
    public void init(){
        storage.add(new Customer(1, "Spring"));
        storage.add(new Customer(2, "Boot"));
    }
}