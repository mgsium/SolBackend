package com.sol.api.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sol.api.dao.conc.LessonRepository;
import com.sol.api.dao.conc.QuestionRepository;
import com.sol.api.model.Lesson;
import com.sol.api.model.Question;

@RestController
@RequestMapping("api/v1/lesson")
public class LessonController {
	
	private final LessonRepository lessonRepo;
	private final QuestionRepository questionRepo;
	
	@Autowired
	public LessonController(LessonRepository lessonRepo, QuestionRepository questionRepo) {
		this.lessonRepo = lessonRepo;
		this.questionRepo = questionRepo;
	}
	
	@PostMapping(path = "/new")
	public String createLesson(@Valid @NotNull @RequestBody Lesson lesson) {
		String lessonId = lessonRepo.generateId();
		lesson.setId(lessonId);
		lesson.setTimestamp(new Timestamp(System.currentTimeMillis()));
		List<Question> questions = lesson.getQuestions();
		lesson.setQuestions(new ArrayList<Question>());
		boolean insertionWasSuccessful = lessonRepo.insertObject(lesson);
		lessonRepo.indexLesson(lesson);
		questions.forEach(q -> { q.setLesson(lesson); questionRepo.insertObject(q); });
		return "redirect:https://www.learnwithsol.com/confirm/" + lessonId;
	}
	
	@PostMapping(path = "/question/new/{lesson_id}")
	public boolean createQuestion(@Valid @NotNull @RequestBody Question question, @PathVariable("lesson_id") String lesson_id) {
		return questionRepo.insertObject(question);
	}
	
	@GetMapping(path = "/get/{lesson_id}")
	public Lesson getLesson(@PathVariable("lesson_id") String lesson_id) {
		Lesson lesson = lessonRepo.retrieveObject(lesson_id, Lesson.class).orElse(null);
		// TODO: Change this
		if (lesson != null) lesson.getQuestions().forEach( q -> { q.setLesson(null); });
		else System.out.println("Not Found");
		return lesson;
	}
	
	@GetMapping(path = "/get/random/{maxResults}")
	public List<Lesson> getRandomLessons(@PathVariable("maxResults") int maxResults) {
		List<Lesson> lessons = lessonRepo.getRandomRecords(maxResults, Lesson.class);
		for(Lesson l: lessons) l.getQuestions().forEach( q -> { q.setLesson(null); });
		return lessons;
	}
	
	@GetMapping(path = "/get/search/{searchString}")
	public List<Lesson> searchForLessons(@PathVariable("searchString") String searchString) {
		List<Lesson> lessons = lessonRepo.searchForLessons(searchString, "header", Lesson.class);
 		for(Lesson l: lessons) l.getQuestions().forEach( q -> { q.setLesson(null); });
 		return lessons;
	}
	
}
