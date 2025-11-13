package com.quizz.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.quizz.dao.QuestionDao;
import com.quizz.dao.QuizzDao;
import com.quizz.model.Question;
import com.quizz.model.QuestionWrapper;
import com.quizz.model.Quizz;
import com.quizz.model.Response;

@Service
public class QuizzService {

	@Autowired
	QuizzDao quizzDao;
	
	@Autowired
	QuestionDao questionDao;
	

	public ResponseEntity<String> createQuizz(String category, int numQ, String title) {
		List<Question> questions= questionDao.findRandomQuestionsByCategory(category,numQ);
		Quizz quizz = new Quizz();	
		
		quizz.setTitle(title);
		quizz.setQuestions(questions);
		quizzDao.save(quizz);
		
		return new ResponseEntity<>("SUCESS",HttpStatus.CREATED);
	}


	public ResponseEntity<List<QuestionWrapper>> getQuizzQuestions(Integer id) {
		Optional<Quizz> byId = quizzDao.findById(id);
		List<Question> questionsFromDB = byId.get().getQuestions();
		List<QuestionWrapper> questionForUser = new ArrayList<QuestionWrapper>();
		for(Question q:questionsFromDB) {
			QuestionWrapper qw=new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
			questionForUser.add(qw);
		}
		return new ResponseEntity<>(questionForUser,HttpStatus.OK);
	}


	public ResponseEntity<Integer> calcuateResult(Integer id, List<Response> responses) {
		Quizz quizz = quizzDao.findById(id).get();
		List<Question> questions = quizz.getQuestions();
		int right=0,i=0;
		for(Response response:responses) {
			if(response.getResponse().equals(questions.get(i).getRightAnswer()))
				right++;
			i++;
		}
		return new ResponseEntity<>(right,HttpStatus.OK);
	}
}
