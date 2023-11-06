package ru.netology.Grishenko.Service;

import ru.netology.Grishenko.Domain.Client;
import ru.netology.Grishenko.Domain.Operation;

public class StorageService {
    public final static int MAX_OPERATIONS = 1_000;
    public final static int MAX_CLIENTS = 100;
    static final Operation[] operations = new Operation[MAX_OPERATIONS];
    static final Client[] clients = new Client[MAX_CLIENTS];

    static final int[][] statmant = new int[MAX_CLIENTS][MAX_OPERATIONS / MAX_CLIENTS];
    static final int[] client_operation_count = new int[MAX_CLIENTS];

    public Client[] getCustomers() {
        return clients;
    }

    public Operation[] getOperations() {
        return operations;
    }

    public int[][] getStatmant() {
        return statmant;
    }

    public int[] getClient_operation_count(){
        return client_operation_count;
    }
}