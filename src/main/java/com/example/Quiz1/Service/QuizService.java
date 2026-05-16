package com.example.Quiz1.Service;

import com.example.Quiz1.Model.Question;
import com.example.Quiz1.Model.QuizSession;
import com.example.Quiz1.Repository.QuestionRepository;
import com.example.Quiz1.Repository.QuizSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class QuizService {
    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QuizSessionRepository quizSessionRepository;

    // 1. Start Quiz
    public QuizSession startQuiz() {
        QuizSession session = new QuizSession();
        return quizSessionRepository.save(session);
    }

    // 2. Get Next Question
    public Object getNextQuestion(Long sessionId) {
        QuizSession session = quizSessionRepository.findById(sessionId).orElseThrow();
        if (session.isQuizEnded()) {
            return "Quiz already ended";
        }
        if (session.getTotalQuestionsAnswered() >= session.getMaxQuestions()) {
            session.setQuizEnded(true);
            quizSessionRepository.save(session);
            return "Quiz End";
        }
        List<Question> allQuestions = questionRepository.findAll();

        // filter already asked
        List<Question> remaining = new ArrayList<>();
        for (Question q : allQuestions) {
            if (!session.getAskedQuestionIds().contains(q.getId())) {
                remaining.add(q);
            }
        }

        if (remaining.isEmpty()) {
            session.setQuizEnded(true);
            quizSessionRepository.save(session);
            return "No more questions";
        }

        Question random = remaining.get(new Random().nextInt(remaining.size()));
        session.getAskedQuestionIds().add(random.getId());
        quizSessionRepository.save(session);
        return random;
    }

    // 3. Submit Answer + Return Next Question
    public Object submitAnswer(Long sessionId, Long questionId, String answer) {
        QuizSession session = quizSessionRepository.findById(sessionId).orElseThrow();

        if (session.isQuizEnded()) {
            return "Quiz already ended";
        }

        Question question = questionRepository.findById(questionId).orElseThrow();
        session.setTotalQuestionsAnswered(session.getTotalQuestionsAnswered() + 1);

        if (question.getCorrectAnswer().equalsIgnoreCase(answer)) {
            session.setCorrectAnswers(session.getCorrectAnswers() + 1);
            session.getAnswerDetails().add("Q" + questionId + ": Correct");
        } else {
            session.setIncorrectAnswers(session.getIncorrectAnswers() + 1);
            session.getAnswerDetails().add("Q" + questionId + ": Incorrect");
        }

        // check limit
        if (session.getTotalQuestionsAnswered() >= session.getMaxQuestions()) {
            session.setQuizEnded(true);
            quizSessionRepository.save(session);
            return "Quiz End";
        }
        quizSessionRepository.save(session);

        // return next question
        return getNextQuestion(sessionId);
    }

    // 4. Get Result
    public QuizSession getResult(Long sessionId) {
        return quizSessionRepository.findById(sessionId).orElseThrow();
    }
}
