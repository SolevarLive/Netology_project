package ru.netology.Grishenko.Service;

import ru.netology.Grishenko.Domain.Client;
import ru.netology.Grishenko.Domain.Operation;

import java.util.ArrayList;
import java.util.List;

public class StorageService<T> {
    private final List<T> storage = new ArrayList<>();
    public final static int MAX_OPERATIONS = 1_000;
    public final static int MAX_CLIENTS = 100;
    static final int[][] statmant = new int[MAX_CLIENTS][MAX_OPERATIONS / MAX_CLIENTS];
    static final int[] client_operation_count = new int[MAX_CLIENTS];
    static final StorageService<Client> customerStorageService = new StorageService<>();
    static final StorageService<Operation> operationStorageService = new StorageService<>();

    public int[][] getStatmant() {
        return statmant;
    }

    public int[] getClient_operation_count() {
        return client_operation_count;
    }

    public static StorageService<Client> getCustomerStorageService(){
        return customerStorageService;
    }
    public static StorageService<Operation> getOperationStorageService(){
        return operationStorageService;
    }

    public T getElement(int position) {
        return storage.get(position);
    }

    public void setElement(T element) {
        storage.add(element);
    }

    @Override
    public String toString() {
        return storage.toString();
    }
}