package com.vtxlab.demo.student.service;

import java.util.List;
import com.vtxlab.demo.student.entity.Student;

public interface StudentService  {

  List<Student> findAllStudents();

  void createStudent(String name, Double height);

  Student deleteStudentById(Long id);

  List<Student> saveAllStudents(List<Student> students);
  
}
