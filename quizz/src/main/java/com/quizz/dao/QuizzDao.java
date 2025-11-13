package com.quizz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quizz.model.Quizz;

@Repository
public interface QuizzDao extends JpaRepository<Quizz, Integer>{

}
