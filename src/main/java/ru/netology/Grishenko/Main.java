package ru.netology.Grishenko;
import ru.netology.Grishenko.Domain.Client;
import ru.netology.Grishenko.Domain.CustomerOperationOutOfBoundException;
import ru.netology.Grishenko.Domain.Operation;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public  final static int MAX_OPERATIONS = 1_000;
    public  final static int MAX_CLIENTS = 100;
    private static final Operation[] operations =new Operation[MAX_OPERATIONS];
    private static final Client[] clients =new Client[MAX_CLIENTS];

    private static final int[][] statmant = new int[MAX_CLIENTS][MAX_OPERATIONS/MAX_CLIENTS];
    private static final int[] client_operation_count =new int[MAX_CLIENTS];


    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);

        inputClient(scanner);
        inputeOperation(scanner);



        System.out.println("Client: " + Arrays.toString(clients));
        System.out.println("Operations: " + Arrays.toString(operations));
        System.out.println("statmant: " + Arrays.deepToString(statmant));
        System.out.println("client_operation_count: " + Arrays.toString(client_operation_count));

    }

    private static void inputClient(Scanner scanner){
        int clientsCount=0;
        while (true){
            System.out.println("Client name: ");
            String name = scanner.nextLine();
            Client client = new Client(clientsCount, name);


            clients[clientsCount] = client;
            clientsCount++;

            System.out.println("Do you want to finish? Y/N");
            String answer = scanner.nextLine();
            if (answer.equals("N")){
                break;
            }

            if (clientsCount ==  MAX_CLIENTS){
                break;
            }
        }
    }

    private static void inputeOperation(Scanner scanner){
        int operationsId=0;
        while (true){
            System.out.println("Sum: ");
            int sum = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Currency: ");
            String currency = scanner.nextLine();

            System.out.println("Merchant: ");
            String merchant = scanner.nextLine();

            Operation operation = new Operation(operationsId, sum, currency, merchant);

            operations[operationsId] = operation;
            operationsId++;

            System.out.println("Client: ");
            int cliintId = scanner.nextInt();
            scanner.nextLine();

            try {
                saveToStatement(statmant, cliintId, operationsId);
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
    public static void saveToStatement(int[][] statmant, int cliintId, int operationsId) throws CustomerOperationOutOfBoundException {
        if (cliintId > MAX_CLIENTS || cliintId < 0 &&
        operationsId > MAX_OPERATIONS || operationsId < 0) {
            throw new CustomerOperationOutOfBoundException(cliintId, operationsId);
        }

        int operationCountClient = client_operation_count[cliintId];
        statmant[cliintId][operationCountClient] = operationsId;
        client_operation_count[cliintId] = operationCountClient+1;
    }
}