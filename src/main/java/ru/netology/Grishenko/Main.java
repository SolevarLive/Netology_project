package ru.netology.Grishenko;
import ru.netology.Grishenko.Domain.Client;
import ru.netology.Grishenko.Domain.CustomerOperationOutOfBoundException;
import ru.netology.Grishenko.Domain.Operation;
import ru.netology.Grishenko.Service.StorageService;

import java.util.Arrays;
import java.util.Scanner;

import static ru.netology.Grishenko.Service.CustomerService.inputClient;
import static ru.netology.Grishenko.Service.OperationService.inputeOperation;

public class Main {
    private static StorageService storageService = new StorageService();

    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);

        inputClient(scanner);
        inputeOperation(scanner);


        System.out.println("Client: " + Arrays.toString(storageService.getCustomers()));
        System.out.println("Operations: " + Arrays.toString(storageService.getOperations()));
        System.out.println("statmant: " + Arrays.deepToString(storageService.getStatmant()));
        System.out.println("client_operation_count: " + Arrays.toString(storageService.getClient_operation_count()));

    }

}