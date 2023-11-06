package ru.netology.Grishenko.Service;

import ru.netology.Grishenko.Domain.CustomerOperationOutOfBoundException;

import static ru.netology.Grishenko.Service.StorageService.*;

public class StatementService {

    public static void saveToStatement(int cliintId, int operationsId) throws CustomerOperationOutOfBoundException {
        if (cliintId > MAX_CLIENTS || cliintId < 0 &&
                operationsId > MAX_OPERATIONS || operationsId < 0) {
            throw new CustomerOperationOutOfBoundException(cliintId, operationsId);
        }

        int operationCountClient = client_operation_count[cliintId];
        statmant[cliintId][operationCountClient] = operationsId;
        client_operation_count[cliintId] = operationCountClient + 1;
    }
}