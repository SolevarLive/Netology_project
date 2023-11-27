package ru.netology.Grishenko.controller.dto;

import lombok.Data;

import java.util.List;

@Data
public class GetClientsResponse {
    private  final List<CustomerDTO> clients;
}
