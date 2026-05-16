package com.example.Quiz1.Controller;

import com.example.Quiz1.Model.Question;
import com.example.Quiz1.Model.QuizSession;
import com.example.Quiz1.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    // Start Quiz http://localhost:8080/quiz/start
    @PostMapping("/start")
    public QuizSession startQuiz() {
        return quizService.startQuiz();
    }

    // Get Question  http://localhost:8080/quiz/question/1
    @GetMapping("/question/{sessionId}")
    public Object getQuestion(@PathVariable Long sessionId) {
        return quizService.getNextQuestion(sessionId);
    }

    // Submit Answer http://localhost:8080/quiz/submit
    @PostMapping("/submit")
    public Object submitAnswer(
            @RequestParam Long sessionId,
            @RequestParam Long questionId,
            @RequestParam String answer) {

        return quizService.submitAnswer(sessionId, questionId, answer);
    }

    // Result http://localhost:8080/quiz/result/1
    @GetMapping("/result/{sessionId}")
    public QuizSession getResult(@PathVariable Long sessionId) {
        return quizService.getResult(sessionId);
    }
}