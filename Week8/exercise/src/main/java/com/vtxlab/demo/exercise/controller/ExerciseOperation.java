package com.vtxlab.demo.exercise.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.vtxlab.demo.exercise.entity.Exercise;


@RequestMapping(value = "/default")
public interface ExerciseOperation {

  @GetMapping(value = "/post")
  List<Exercise> findAllExercise();


  
}
