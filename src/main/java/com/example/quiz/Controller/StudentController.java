package com.example.quiz.Controller;

import com.example.quiz.ApiRespons.ApiResponseStudent;
import com.example.quiz.Model.Student;
import com.example.quiz.Servicee.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/student")
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/get")
    public ResponseEntity getStudent() {
        ArrayList<Student> students = new ArrayList<>();
        return ResponseEntity.ok(students);


    }

    @PostMapping("/add")
  public ResponseEntity addStudent(@Valid @RequestBody Student student, Errors errors) {
        if (errors.hasErrors()) {
            String message =errors.getFieldError().getDefaultMessage();
            return ResponseEntity.badRequest().body(message);
        }
        studentService.addStudent(student);
        return ResponseEntity.status(200).body(new ApiResponseStudent("student added successfully"));


    }
    @PostMapping("/update/{id}")
    public ResponseEntity updateStudent(@PathVariable int id,@Valid @RequestBody Student student,Errors errors) {
        if (errors.hasErrors()) {
            String message =errors.getFieldError().getDefaultMessage();
            return ResponseEntity.badRequest().body(message);

        }


       boolean isUpdated = studentService.updateStudent(id, student);
        if (isUpdated) {
            return ResponseEntity.status(200).body(new ApiResponseStudent("student updated successfully"));
        }
        return ResponseEntity.status(404).body(new ApiResponseStudent("student not found"));
    }

    @DeleteMapping("/delete{id}")
    public ResponseEntity DeleteStudent(@PathVariable int id) {
        boolean isDeleted = studentService.deleteStudent(id);
        if (isDeleted) {
            return ResponseEntity.status(200).body(new ApiResponseStudent("student deleted successfully"));

        }
        return ResponseEntity.status(404).body(new ApiResponseStudent("student not found"));
    }
    @GetMapping("/get/{name}")
    public ResponseEntity getStudentsByName(@PathVariable String name) {
        studentService.getStudentsByName(name);
       return ResponseEntity.ok(studentService.getStudents());
    }
    @GetMapping("/get{major}")
public ResponseEntity getStudentsByMajor(@PathVariable String major) {
        studentService.getStudentsByMajor(major);
      return ResponseEntity.ok(studentService.getStudents());
    }

    }

