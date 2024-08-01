package com.example.quiz.Controller;

import com.example.quiz.ApiRespons.ApiResponseTeacher;
import com.example.quiz.Model.Teacher;
import com.example.quiz.Servicee.TecherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor
public class CotrollerTeacher {
    private final TecherService techerService;

    @GetMapping("/get")
    public ResponseEntity getAllTeachers(){
        ArrayList<Teacher> teachers = techerService.getAllTeachers();
        return ResponseEntity.ok(teachers);

    }
    @PostMapping("/add")
    public ResponseEntity addTeacher( @Valid @RequestBody Teacher teacher, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.badRequest().body(message);
        }
        techerService.addTeacher(teacher);
        return ResponseEntity.status(200).body(new ApiResponseTeacher("teacher added successfully"));


    }
    @PutMapping("/update/{id} ")
    public ResponseEntity updateTeacher(@PathVariable int id,@Valid @RequestBody Teacher teacher,Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.badRequest().body(message);

        }
        boolean isUpdated= techerService.updateTeacher(id,teacher);
        if(isUpdated){
            return ResponseEntity.status(200).body(new ApiResponseTeacher("teacher updated successfully"));
        }
        return ResponseEntity.status(404).body(new ApiResponseTeacher("teacher not found"));
    }
    public ResponseEntity deleteTeacher(@PathVariable int id){
        boolean isDeleted= techerService.deleteTeacher(id);
        if(isDeleted){
            return ResponseEntity.status(200).body(new ApiResponseTeacher("teacher deleted successfully"));

        }
        return ResponseEntity.status(404).body(new ApiResponseTeacher("teacher not found"));

    }
    @GetMapping("getTeacher/{id}")
    public ResponseEntity getbyId(@PathVariable int id){
        techerService.getbyId(id);
                return ResponseEntity.ok(new ApiResponseTeacher("teacher found successfully"));
    }
@GetMapping("/salary/{salary}")
    public ResponseEntity getTeachersBySalaryRange(@PathVariable int salary){
        techerService.getTeachersBySalaryRange(salary);
        return ResponseEntity.ok(new ApiResponseTeacher("teacher found successfully"));
}


}
