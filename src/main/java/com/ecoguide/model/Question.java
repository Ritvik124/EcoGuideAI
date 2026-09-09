package com.ecoguide.model;

/** Data recorded for one anonymous EcoGuide AI question. */
public class Question {
    private final String question;
    private final String answer;
    private final String category;
    private final int ecoScore;

    public Question(String question, String answer, String category, int ecoScore) {
        this.question = question;
        this.answer = answer;
        this.category = category;
        this.ecoScore = ecoScore;
    }
    public String getQuestion() { return question; }
    public String getAnswer() { return answer; }
    public String getCategory() { return category; }
    public int getEcoScore() { return ecoScore; }
}
