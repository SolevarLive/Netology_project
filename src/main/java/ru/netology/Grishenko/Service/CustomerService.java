package ru.netology.Grishenko.Service;

import ru.netology.Grishenko.Domain.Client;

import java.util.Scanner;

import static ru.netology.Grishenko.Service.StorageService.MAX_CLIENTS;
import static ru.netology.Grishenko.Service.StorageService.clients;
import static ru.netology.Grishenko.Service.lOService.inputClient;
import static ru.netology.Grishenko.Service.lOService.inputToFinish;

public class CustomerService {

    public static void saveClient(){
        int clientsCount=0;
        while (true){
            Client client = new Client(clientsCount, inputClient());


            clients[clientsCount] = client;
            clientsCount++;

            if (inputToFinish().equals("N")){
                break;
            }

            if (clientsCount ==  MAX_CLIENTS){
                break;
            }
        }
    }
}
