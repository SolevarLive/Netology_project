package ru.netology.Grishenko.Service;

import org.junit.jupiter.api.Test;
import ru.netology.Grishenko.Domain.Operation;
import ru.netology.Grishenko.configuration.OperationsProcessingProperties;

import static org.junit.jupiter.api.Assertions.*;

class AsyncInputOperationServiceTest {
    @Test
    public void testAddOperation() {
        AsyncInputOperationService asyncInputOperationService = new AsyncInputOperationService(new StatementService(), new OperationsProcessingProperties());
        Operation operation = new Operation();
        assertTrue(asyncInputOperationService.addOperation(operation));
        assertTrue(asyncInputOperationService.addOperation(null));
    }

    @Test
    public void startProcessingTest() {
        AsyncInputOperationService asyncInputOperationService = new AsyncInputOperationService(new StatementService(), new OperationsProcessingProperties());
        asyncInputOperationService.startProcessing();
    }
}
