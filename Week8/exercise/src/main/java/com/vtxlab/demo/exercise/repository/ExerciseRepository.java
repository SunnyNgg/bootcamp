package com.vtxlab.demo.exercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vtxlab.demo.exercise.entity.Exercise;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long>{

  
  
}
