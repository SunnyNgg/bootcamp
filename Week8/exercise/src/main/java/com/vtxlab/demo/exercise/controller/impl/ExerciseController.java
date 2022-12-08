package com.vtxlab.demo.exercise.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.demo.exercise.controller.ExerciseOperation;
import com.vtxlab.demo.exercise.entity.Exercise;
import com.vtxlab.demo.exercise.service.ExerciseService;

@RestController
@RequestMapping (value = "/abc/api/v1")
public class ExerciseController implements ExerciseOperation {

  @Autowired
  ExerciseService exerciseService;

  @Override
  public List<Exercise> findAllExercise(){
    return exerciseService.findAllExercise();
  }

  
}
