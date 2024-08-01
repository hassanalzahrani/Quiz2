package com.example.quiz.Servicee;

import com.example.quiz.Model.Teacher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TecherService {

   ArrayList<Teacher> teachers = new ArrayList<>();
   public ArrayList<Teacher> getAllTeachers() {
       return teachers;

   }
   public void addTeacher(Teacher teacher) {
       teachers.add(teacher);
   }
  public boolean updateTeacher(int id,Teacher teacher) {
       for (int i = 0; i < teachers.size(); i++) {
           if (teachers.get(i).getId() == id) {
               teachers.set(i, teacher);
               return true;
           }
       }
       return false;
  }
  public boolean deleteTeacher(int id) {
       for (int i = 0; i < teachers.size(); i++) {
           if (teachers.get(i).getId() == id) {
               teachers.remove(i);
               return true;
           }
       }
        return false;
  }
  public ArrayList<Teacher> getbyId(int id) {
       for (int i = 0; i < teachers.size(); i++) {
           if (teachers.get(i).getId() == id) {
               return teachers;

           }
       }
       return null;
  }
  public ArrayList<Teacher> getTeachersBySalaryRange(double salary) {
       ArrayList<Teacher> teachers1 = new ArrayList<>();
       for (int i = 0; i < teachers.size(); i++) {
           if (teachers.get(i).getSalary() == salary) {
               teachers.add(teachers.get(i));

           }
       }
       return teachers;
  }

}
