package ru.netology.Grishenko.Service;

import ru.netology.Grishenko.Domain.CustomerOperationOutOfBoundException;
import ru.netology.Grishenko.Domain.Operation;

import static ru.netology.Grishenko.Service.StatementService.saveToStatement;
import static ru.netology.Grishenko.Service.StorageService.operations;
import java.util.Scanner;

import static ru.netology.Grishenko.Service.StorageService.*;

public class OperationService {

    public static void inputeOperation(Scanner scanner){
        int operationsId=0;
        while (true){
            System.out.println("Sum: ");
            int sum = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Currency: ");
            String currency = scanner.nextLine();

            System.out.println("Merchant: ");
            String merchant = scanner.nextLine();

            System.out.println("Client: ");
            int cliintId = scanner.nextInt();
            scanner.nextLine();

            Operation operation = new Operation(operationsId, sum, currency, merchant);

            operations[operationsId] = operation;
            operationsId++;

            try {
                saveToStatement(cliintId, operationsId);
            } catch (CustomerOperationOutOfBoundException e) {
                System.out.println("Error while saving operation to statement: " + e.getMessage());
            }

            System.out.println("Do you want to finish? Y/N");
            String answer = scanner.nextLine();
            if (answer.equals("N")){
                break;
            }

            if (operationsId == MAX_OPERATIONS){
                break;
            }
        }
    }

}
