package ru.netology.Grishenko.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ru.netology.Grishenko.Domain.Customer;
import ru.netology.Grishenko.Domain.CustomerOperationOutOfBoundException;
import ru.netology.Grishenko.Domain.Operation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@AllArgsConstructor
public class StatementService {
    private final Map<Integer, List<Operation>> storage = new HashMap<>();

    public void saveOperation(Operation operation, Customer client) {
        List<Operation> operations = storage.get(client.getId());
        if (operations == null) {
            List<Operation> customerOperations = new ArrayList<>();
            customerOperations.add(operation);
            storage.put(client.getId(), customerOperations);
        } else {
            operations.add(operation);
        }
    }
    public Map<Integer, List<Operation>> getOperations(){
        return storage;
    }
}