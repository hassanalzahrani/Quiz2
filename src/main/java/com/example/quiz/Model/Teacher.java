package com.example.quiz.Model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Valid
public class Teacher {
    @NotNull(message = "ID  should not be empty")
    private int id;
    @NotEmpty(message = "Name should not be empty")
    private String name;
    @NotNull(message = "Salary should bot be empty")
    private int salary;
}
