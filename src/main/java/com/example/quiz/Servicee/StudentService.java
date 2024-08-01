package com.example.quiz.Servicee;

import com.example.quiz.Model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentService {
    ArrayList<Student> students = new ArrayList<Student>();
public ArrayList<Student> getStudents() {
    return students;

}
    public void addStudent(Student student) {
        students.add(student);

    }

    public boolean updateStudent(int id,Student student) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                students.set(i, student);
                return true;
            }
        }
        return false;
    }
    public boolean deleteStudent(int id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                students.remove(i);
                return true;
            }
        }
        return false;
    }
    public ArrayList<Student> getStudentsByName(String name) {
    for (int i = 0; i < students.size(); i++) {
        if (students.get(i).getName().equals(name)) {
            return students;

        }
    }
    return null;
    }
    public ArrayList<Student> getStudentsByMajor(String major) {
    for (int i = 0; i < students.size(); i++) {
        if (students.get(i).getMajor().equals(major)) {
            return students;

        }
    }
    return null;
    }

}
