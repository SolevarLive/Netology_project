package ru.netology.Grishenko;
import ru.netology.Grishenko.Domain.Client;
import ru.netology.Grishenko.Domain.CustomerOperationOutOfBoundException;
import ru.netology.Grishenko.Domain.Operation;
import ru.netology.Grishenko.Service.StorageService;

import java.util.Arrays;
import java.util.Scanner;

import static ru.netology.Grishenko.Service.CustomerService.saveClient;
import static ru.netology.Grishenko.Service.OperationService.saveOperation;
import static ru.netology.Grishenko.Service.lOService.outputValues;

public class Main {
    public static StorageService storageService = new StorageService();

    public static void main(String[] args) {
        saveClient();
        saveOperation();


        outputValues();

    }

}