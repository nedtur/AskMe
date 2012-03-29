/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hist.askme.models;

import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author Håvard
 */
public class Question {
    private String question; 
    private int amountOfAnswers;
    private ArrayList<String> answers = new ArrayList<String>();
    UUID ID;
    
    public Question(String question, int amountOfAnswers, ArrayList<String> answers) {
        this.question = question;
        this.amountOfAnswers = amountOfAnswers;
        this.answers = answers;
        
        ID = UUID.randomUUID();
    }
    
    public UUID getID() {return ID;}
    public String getQuestion() { return question; }
    public int getAmountOfAnswers() { return amountOfAnswers; }
    public ArrayList<String> getAnswers() { return answers; }
    
    public void setQuestion(String newQ) { question=newQ; }
    public void setAmountOfAnswers(int newAm) { amountOfAnswers=newAm; }
    public void setAnswers(ArrayList<String> newAns) { answers=newAns; }
    
}
