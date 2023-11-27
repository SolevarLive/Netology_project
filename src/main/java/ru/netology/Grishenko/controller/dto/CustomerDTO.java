package ru.netology.Grishenko.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerDTO {
    private final int id;
    private  final  String name;
}

