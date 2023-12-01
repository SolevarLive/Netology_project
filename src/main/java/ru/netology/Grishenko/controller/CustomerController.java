package ru.netology.Grishenko.controller;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    public GetClientsResponse getClients() {
        List<Customer> customers = customerService.getCustomers();


        List<CustomerDTO> customerDTOS = new ArrayList<>();
        for (Customer customer : customers) {
            CustomerDTO customerDTO = new CustomerDTO(customer.getId(), customer.getName());
            customerDTOS.add(customerDTO);
        }
        return new GetClientsResponse(customerDTOS);
    }

    @GetMapping("/{customerId}")
    public CustomerDTO getCustomer(@PathVariable int customerId) {
        for (Customer customer : customerService.getCustomers()) {
            if (customer.getId() == customerId) {
                CustomerDTO customerDTO = new CustomerDTO(customer.getId(), customer.getName());
                return customerDTO;
            }
        }
        return null;
    }

    @PostMapping
    public void addCustomer(@RequestBody CustomerDTO newCustomer) {
        customerService.addCustomer(newCustomer.getId(), newCustomer.getName());
        System.out.println("Customer added successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable(name = "id") int customerId) {
        List<Customer> customers = customerService.getCustomers();
        customers.removeIf(customer -> customer.getId() == customerId);
        return ResponseEntity.ok("Customer with ID " + customerId + " has been deleted");
    }


}
