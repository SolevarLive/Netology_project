package ru.netology.Grishenko.controller.dto;

import lombok.Data;

import java.util.List;

@Data
public class GetOperationResponse {
    private final List<OperationDTO> operations;
}
