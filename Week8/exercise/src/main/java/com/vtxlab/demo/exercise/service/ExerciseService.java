package com.vtxlab.demo.exercise.service;

import java.util.List;
import com.vtxlab.demo.exercise.entity.Exercise;

public interface ExerciseService {
  
  List<Exercise> findAllExercise();
  
}
