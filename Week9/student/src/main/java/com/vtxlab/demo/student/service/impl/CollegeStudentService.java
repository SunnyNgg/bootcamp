package com.vtxlab.demo.student.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.vtxlab.demo.student.entity.Student;
import com.vtxlab.demo.student.exception.KeyNotFindException;
import com.vtxlab.demo.student.repository.StudentRepository;
import com.vtxlab.demo.student.service.StudentService;


// private static 
@Service
public class CollegeStudentService implements StudentService {

  @Autowired
  StudentRepository studentRepository;

  @Autowired
  @Qualifier(value = "beanForVincent")
  Student studentVincent;

  @Autowired
  @Qualifier(value = "beanForAlan")
  Student studentAlan; 

  @Override
  public List<Student> findAllStudents() {
    return studentRepository.findAll();
  }

  @Override
  public void createStudent(String name, Double height){
    studentRepository.createStudent(name, height);
  } 

  @Override
  public Student deleteStudentById(Long id)throws IllegalArgumentException{
    Student student = studentRepository.findById(id).orElse(null);
    if (student != null) {
      studentRepository.deleteById(id);
      return student;
  }
    throw new KeyNotFindException();
  }
    @Override

    public List<Student> saveAllStudents(List<Student> students){
      return studentRepository.saveAll(students);

    


  
}
}
