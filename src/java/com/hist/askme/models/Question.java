/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hist.askme.models;

/**
 *
 * @author Håvard
 */
public class Question {
    private String question; 
    private int amountOfAnswers;
    private String[] answers;
    
    public Question(String question, int amountOfAnswers, String[] answers) {
        this.question = question;
        this.amountOfAnswers = amountOfAnswers;
        this.answers = answers;
    }
    
    public String getQuestion() { return question; }
    public int getAmountOfAnswers() { return amountOfAnswers; }
    public String[] getAnswers() { return answers; }
    
    public void setQuestion(String newQ) { question=newQ; }
    public void setAmountOfAnswers(int newAm) { amountOfAnswers=newAm; }
    public void setAnswers(String[] newAns) { answers=newAns; }
    
}
