/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hist.askme.models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *
 * @author Håvard
 */
public class Question {
    private String question; 
    private List<Answer> answers = new CopyOnWriteArrayList<Answer>();
    private List<String> answerString = new CopyOnWriteArrayList<String>();
    UUID ID;
    
    public Question() {}
    public Question(String question, List<Answer> answers) {
        this.question = question;
        this.answers = answers;
        for(Answer a : answers) {
            answerString.add(a.getText());
        }
        
        ID = UUID.randomUUID();
    }
    
    public UUID getID() {return ID;}
    public String getQuestion() { return question; }
    public List<Answer> getAnswers() { return answers; }
    public List<String> getAnswerString() { return answerString; }
    
    public void setQuestion(String newQ) { question=newQ; }
    public void setAnswers(ArrayList<Answer> newAns) { answers=newAns; }
    
    public void addAnswer(String answer) {
        answers.add(new Answer(answer));
    }
    
    public void deleteAnswer(Answer answer) {
        for(Iterator<Answer> iter = answers.iterator(); iter.hasNext();) {
            Answer ans = iter.next();
            if(answer.equals(ans)) {
                answers.remove(ans);
            }
        }
    }
    
    public String getQuestionType() {
        return "Type:"+this.getClass();
    }
    
}
