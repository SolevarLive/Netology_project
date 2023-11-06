package ru.netology.Grishenko.Service;

import ru.netology.Grishenko.Domain.Client;

import java.util.Scanner;

import static ru.netology.Grishenko.Service.StorageService.MAX_CLIENTS;
import static ru.netology.Grishenko.Service.StorageService.clients;

public class CustomerService {

    public static void inputClient(Scanner scanner){
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
}
