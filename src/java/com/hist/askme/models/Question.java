/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hist.askme.models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *
 * @author Håvard
 */
public class Question {
    private String question; 
    private int amountOfAnswers;
    private List<String> answers = new CopyOnWriteArrayList<String>();
    
    public Question(String question, int amountOfAnswers, List<String> answers) {
        this.question = question;
        this.amountOfAnswers = amountOfAnswers;
        this.answers = answers;
        
        ID = UUID.randomUUID();
    }
    
    public UUID getID() {return ID;}
    public String getQuestion() { return question; }
    public int getAmountOfAnswers() { return amountOfAnswers; }
    public List<String> getAnswers() { return answers; }
    
    public void setQuestion(String newQ) { question=newQ; }
    public void setAmountOfAnswers(int newAm) { amountOfAnswers=newAm; }
    public void setAnswers(ArrayList<String> newAns) { answers=newAns; }
    
    public void addAnswer(String answer) {
        answers.add(answer);
    }
    
    public void deleteAnswer(String answer) {
        for(Iterator<String> iter = answers.iterator(); iter.hasNext();) {
            String ans = iter.next();
            if(answer.equals(ans)) {
                answers.remove(ans);
            }
        }
    }
}
