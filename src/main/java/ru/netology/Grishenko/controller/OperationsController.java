package ru.netology.Grishenko.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.netology.Grishenko.Domain.Operation;
import ru.netology.Grishenko.Service.AsyncInputOperationService;
import ru.netology.Grishenko.Service.StatementService;
import ru.netology.Grishenko.controller.dto.GetOperationResponse;
import ru.netology.Grishenko.controller.dto.OperationDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path= "/api/operations/")
@RequiredArgsConstructor
public class OperationsController {
    private final StatementService statementService;
    private final AsyncInputOperationService asyncInputOperationService;

    @GetMapping
    public GetOperationResponse getOperations() {
        Map<Integer, List<Operation>> operations = statementService.getOperations();
        List<OperationDTO> operationDTOS = new ArrayList<>();

        for (List<Operation> operationsList : operations.values()) {
            for (Operation operation: operationsList) {
                OperationDTO operationDTO = new OperationDTO(operation.getId(),
                        operation.getSum(),
                        operation.getCurrency(),
                        operation.getMerchant());
                operationDTOS.add(operationDTO);
            }
        }
        return new GetOperationResponse(operationDTOS);
    }

    @GetMapping(path = "/{id}")
    public OperationDTO getOperation(@PathVariable int id) {
        OperationDTO operationDTO = null;
        for (List<Operation> operations : statementService.getOperations().values()) {
            operationDTO = operations.stream()
                    .filter(operation -> operation.getId() == id)
                    .map(operation -> new OperationDTO(operation.getId(),
                            operation.getSum(),
                            operation.getCurrency(),
                            operation.getMerchant()))
                    .findFirst().orElse(null);
        }
        return operationDTO;
    }

    @PostMapping
    public void setOperation(@RequestBody OperationDTO operationDTOS) {
        asyncInputOperationService.addOperation(new Operation( operationDTOS.getId(), operationDTOS.getSum(),
                operationDTOS.getCurrency(),operationDTOS.getMerchant()
        ));
    }

    @DeleteMapping(path = "/{id}")
    public void deleteOperation(@PathVariable int id) {
        List<Operation> operations = statementService.getOperations().get(id);
        operations.removeIf(operation -> operation.getId() == id);
    }
}

