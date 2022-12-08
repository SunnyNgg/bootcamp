package com.vtxlab.demo.student.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.demo.student.controller.StudentOperation;
import com.vtxlab.demo.student.entity.Student;
import com.vtxlab.demo.student.response.ApiResponse;
import com.vtxlab.demo.student.service.StudentService;


@RestController // Controller + ResponseBody
@RequestMapping(value = "/api/v1")
public class StudentController implements StudentOperation{

  @Autowired
  StudentService studentService;

  @Override
  public ResponseEntity <List<Student>> findAllStudents() {
  return ResponseEntity.ok().body(studentService.findAllStudents());
  }


  @Override
  public ResponseEntity <ApiResponse<Void>> createStudent(String name, Double height) {
  studentService.createStudent(name, height);
  ApiResponse response = ApiResponse.<Void>builder()
  .code(120)
  .message("success insert")
  .data(null)
  .build();
  return ResponseEntity.ok().body(response);
  }

  @Override 
  public ResponseEntity<ApiResponse<Student>> deleteStudentById(Long id){
    studentService.deleteStudentById(id);
    ApiResponse response = ApiResponse.<Student>builder()
    .code(120)
    .message("succes delete")
    .data(null)
    .build();
    return ResponseEntity.ok().body(response);

  }

  @Override
  public ResponseEntity <ApiResponse<List<Student>>> saveAllStudents(List<Student> student){
    studentService.saveAllStudents(student);
    ApiResponse response = ApiResponse.<Student>builder()
    .code(130)
    .message("save all succes")
    .data(null)
    .build();
    return ResponseEntity.ok().body(response);

  }


  
}
