package com.vtxlab.demo.student.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.vtxlab.demo.student.entity.Student;
import com.vtxlab.demo.student.response.ApiResponse;

@RequestMapping(value = "/default")
public interface StudentOperation {

  @GetMapping(value = "/student")
  ResponseEntity <List<Student>> findAllStudents();

  @PostMapping(value = "/student/name/{name}/height/{height}")
  ResponseEntity <ApiResponse<Void>> createStudent(@PathVariable String name, @PathVariable Double height); 

  //void createStudent();

  @DeleteMapping(value="/student/id/{id}")
  ResponseEntity<ApiResponse<Student>> deleteStudentById(@PathVariable Long id);

  @PostMapping(value = "/students")
  ResponseEntity <ApiResponse<List<Student>>> saveAllStudents(@RequestBody List<Student> student);
  
}
