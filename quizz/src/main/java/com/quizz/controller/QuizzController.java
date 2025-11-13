package com.quizz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quizz.model.QuestionWrapper;
import com.quizz.model.Response;
import com.quizz.service.QuizzService;

@RestController
@RequestMapping("/quizz")
public class QuizzController {

	@Autowired
	QuizzService quizzService;
	
	@PostMapping("/create")
	public ResponseEntity<String> createQuizz(@RequestParam String category,@RequestParam int numQ, @RequestParam String title){
		return quizzService.createQuizz(category,numQ,title);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<List<QuestionWrapper>> getQuizzQuestions(@PathVariable Integer id){
		return quizzService.getQuizzQuestions(id);
	}
	
	// results 
	@PostMapping("/submit/{id}")
	public ResponseEntity<Integer> submitQuizz(@PathVariable Integer id,@RequestBody List<Response> responses){

		return quizzService.calcuateResult(id,responses);
	}
}
