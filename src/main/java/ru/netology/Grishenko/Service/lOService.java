package ru.netology.Grishenko.Service;

import ru.netology.Grishenko.Domain.Operation;

import java.util.Arrays;
import java.util.Scanner;

import static ru.netology.Grishenko.Main.storageService;

public class lOService {
    static Scanner scanner= new Scanner(System.in);

    public static String inputClient(){
        System.out.println("Client name: ");
        return scanner.nextLine();
    }


    public static Operation inputOperation(int operationsId){
        System.out.println("Sum: ");
        int sum = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Currency: ");
        String currency = scanner.nextLine();

        System.out.println("Merchant: ");
        String merchant = scanner.nextLine();


        return new Operation(operationsId, sum, currency, merchant);
    }

    public static int clinID(){
        System.out.println("Client: ");
        int cliintId = scanner.nextInt();
        scanner.nextLine();
        return cliintId;
    }
    public static void outputValues(){
        System.out.println("Client: " + Arrays.toString(storageService.getCustomers()));
        System.out.println("Operations: " + Arrays.toString(storageService.getOperations()));
        System.out.println("statmant: " + Arrays.deepToString(storageService.getStatmant()));
        System.out.println("client_operation_count: " + Arrays.toString(storageService.getClient_operation_count()));
    }

    public static String inputToFinish(){
        System.out.println("Do you want to finish? Y/N");
        String answer = scanner.nextLine();
        return answer;
    }


}
