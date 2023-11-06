package ru.netology.Grishenko.Service;

import ru.netology.Grishenko.Domain.CustomerOperationOutOfBoundException;
import ru.netology.Grishenko.Domain.Operation;

import static ru.netology.Grishenko.Service.StatementService.saveToStatement;
import static ru.netology.Grishenko.Service.StorageService.operations;
import java.util.Scanner;

import static ru.netology.Grishenko.Service.StorageService.*;
import static ru.netology.Grishenko.Service.lOService.*;

public class OperationService {

    public static void saveOperation(){
        int operationsId=0;
        while (true){
            operations[operationsId] = inputOperation(operationsId);
            operationsId++;

            try {
                saveToStatement(clinID(), operationsId);
            } catch (CustomerOperationOutOfBoundException e) {
                System.out.println("Error while saving operation to statement: " + e.getMessage());
            }


            if (inputToFinish().equals("N")){
                break;
            }

            if (operationsId == MAX_OPERATIONS){
                break;
            }
        }
    }

}
