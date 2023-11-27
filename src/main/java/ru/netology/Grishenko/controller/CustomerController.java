package ru.netology.Grishenko.controller;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.Grishenko.Domain.Customer;
import ru.netology.Grishenko.Service.CustomerService;
import ru.netology.Grishenko.controller.dto.CustomerDTO;
import ru.netology.Grishenko.controller.dto.GetClientsResponse;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path= "/api/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping
    public GetClientsResponse getClients(){
         List<Customer> customers = customerService.getCustomers();



         List<CustomerDTO> customerDTOS = new ArrayList<>();
         for(Customer customer: customers){
            CustomerDTO customerDTO  = new CustomerDTO(customer.getId(), customer.getName());
            customerDTOS.add(customerDTO);
         }
        return new GetClientsResponse(customerDTOS);
    }

    @GetMapping("/{id}")
    public CustomerDTO getCustomer(@PathVariable(name= "id") int customerId){
        for(Customer customer : customerService.getCustomers()){
            if (customer.getId() == customerId){
                CustomerDTO customerDTO =  new CustomerDTO(customer.getId(), customer.getName());
                return customerDTO;
            }
        }
        return null;
    }
}
