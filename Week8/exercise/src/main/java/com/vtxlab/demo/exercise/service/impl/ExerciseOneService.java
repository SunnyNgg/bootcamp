package com.vtxlab.demo.exercise.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vtxlab.demo.exercise.entity.Exercise;
import com.vtxlab.demo.exercise.repository.ExerciseRepository;
import com.vtxlab.demo.exercise.service.ExerciseService;


@Service
public class ExerciseOneService implements ExerciseService {

  @Autowired
  ExerciseRepository exerciseRepository;

  @Override
  public List<Exercise> findAllExercise(){
    return exerciseRepository.findAll();
  }


  
}
