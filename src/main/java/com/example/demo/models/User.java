package com.example.demo.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record User(
        @NotNull(message = "ID не может быть null")
        @Positive(message = "ID должен быть положительным")
        Long id,

        @NotBlank(message = "Имя не может быть пустым")
        String name,

        @NotBlank(message = "Возраст не может быть пустым")
        @Positive(message = "Возраст должен быть положительным")
        int age
) { }