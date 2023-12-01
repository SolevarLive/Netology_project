package ru.netology.Grishenko.Service;

import org.junit.jupiter.api.Test;
import ru.netology.Grishenko.Domain.Customer;
import ru.netology.Grishenko.Domain.Operation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


class StatementServiceTest {
    @Test
    public void saveOperationTest() {
        StatementService statementService = new StatementService();
        Customer customer = new Customer(1, "Spring");
        Operation operation = new Operation(1,100,"deposit","coffe");

        statementService.saveOperation(operation, customer);
        Map<Integer, List<Operation>> operations = statementService.getOperations();

        assertNotNull(operations.get(customer.getId()));
        assertEquals(1, operations.get(customer.getId()).size());
        assertEquals(operation, operations.get(customer.getId()).get(0));
    }

    @Test
    public void testGetOperations() {
        StatementService statementService = new StatementService();
        Map<Integer, List<Operation>> expectedOperations = new HashMap<>();
        Map<Integer, List<Operation>> actualOperations = statementService.getOperations();
        assertEquals(expectedOperations, actualOperations);
    }
}