package com.example.Quiz1.Model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class QuizSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int totalQuestionsAnswered = 0;
    private int correctAnswers = 0;
    private int incorrectAnswers = 0;

    private int maxQuestions = 5;

    @ElementCollection
    private List<Long> askedQuestionIds = new ArrayList<>();

    @ElementCollection
    private List<String> answerDetails = new ArrayList<>();

    private boolean quizEnded = false;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTotalQuestionsAnswered() {
        return totalQuestionsAnswered;
    }

    public void setTotalQuestionsAnswered(int totalQuestionsAnswered) {
        this.totalQuestionsAnswered = totalQuestionsAnswered;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(int correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    public int getIncorrectAnswers() {
        return incorrectAnswers;
    }

    public void setIncorrectAnswers(int incorrectAnswers) {
        this.incorrectAnswers = incorrectAnswers;
    }

    public int getMaxQuestions() {
        return maxQuestions;
    }

    public void setMaxQuestions(int maxQuestions) {
        this.maxQuestions = maxQuestions;
    }

    public List<Long> getAskedQuestionIds() {
        return askedQuestionIds;
    }

    public void setAskedQuestionIds(List<Long> askedQuestionIds) {
        this.askedQuestionIds = askedQuestionIds;
    }

    public List<String> getAnswerDetails() {
        return answerDetails;
    }

    public void setAnswerDetails(List<String> answerDetails) {
        this.answerDetails = answerDetails;
    }

    public boolean isQuizEnded() {
        return quizEnded;
    }

    public void setQuizEnded(boolean quizEnded) {
        this.quizEnded = quizEnded;
    }
}