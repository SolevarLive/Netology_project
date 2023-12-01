package ru.netology.Grishenko.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.netology.Grishenko.Domain.Customer;
import ru.netology.Grishenko.Domain.Operation;
import ru.netology.Grishenko.Service.AsyncInputOperationService;
import ru.netology.Grishenko.Service.CustomerService;
import ru.netology.Grishenko.Service.StatementService;
import ru.netology.Grishenko.controller.dto.GetOperationResponse;
import ru.netology.Grishenko.controller.dto.OperationDTO;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "api/operations/")
@RequiredArgsConstructor
public class OperationsController {
    private final AsyncInputOperationService operationService;
    private final StatementService statementService;
    private final CustomerService customerService;

    @GetMapping(path = "/{clientId}")
    public List<Operation> getOperation(@PathVariable int clientId) {
        Map<Integer, List<Operation>> clientOperations = statementService.getOperations();
        return clientOperations.get(clientId);
    }

    @PostMapping(path = "/{clientId}")
    @ResponseStatus
    public String setOperation(@RequestBody OperationDTO operation, @PathVariable int clientId) {
        for (Customer client : customerService.getCustomers()) {
            if (client.getId() == clientId) {
                statementService.saveOperation(new Operation(operation.getId(), operation.getSum(),
                                operation.getCurrency(),
                                operation.getMerchant()),
                        client);
                operationService.addOperation(new Operation(operation.getId(), operation.getSum(),
                        operation.getCurrency(),
                        operation.getMerchant()));

                return "Success";
            }
        }

        return "Failed";
    }
    @DeleteMapping(path = "/{clientId}/{operationId}")
    public GetOperationResponse deleteOperation(@PathVariable int clientId, @PathVariable int operationId) {
        List<Operation> operations = statementService.getOperations().get(clientId);
        operations.removeIf(operation -> operation.getId() == operationId);
        List<OperationDTO> operationDTOS = operations.stream()
                .map(operation -> new OperationDTO(operation.getId(),
                        operation.getSum(), operation.getCurrency(), operation.getMerchant()))
                .toList();
        return new GetOperationResponse(operationDTOS);
    }
}

