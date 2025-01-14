package com.example.quiz.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    @NotNull(message = "ID should not be empty")
private int id;
    @NotEmpty(message = "Name should not be empty")
    private String name;
    @NotNull(message = "Age should not be empty")
    private int age;
    @NotEmpty(message = "Major should not be empty ")
    private String major ;



}
