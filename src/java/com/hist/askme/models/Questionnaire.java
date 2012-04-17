/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hist.askme.models;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Håvard
 */

public class Questionnaire {
    private static final ArrayList<Question> questions = new ArrayList<Question>();
    private boolean published;
    
    public Questionnaire() {
        published = false;
    }
    
    public void publish() {
        published = true;
    }
    
    public boolean getPublished() {
        return published;
    }
    
    public ArrayList<Question> getQuestions() {
        return questions;
    }
    public Question getQuestionByString(String question) {
        for(Question q : questions) {
            if(q.getQuestion().equalsIgnoreCase(question)) {
                return q;
            }
        }
        return null;
    }
    public Question getQuestionById(int id) {
        return questions.get(id);
    }    
    public void addQuestion(Question question){
        questions.add(question);
    }
    public void deleteQuestion(Question question) {
        questions.remove(question);
    }
    public void addAnswer(Question q, String answer) {
        q.addAnswer(answer);
    }
    public void deleteAnswer(Question q, Answer answer) {
        q.deleteAnswer(answer);
    }
    public List<Answer> getAnswers(Question q) {
        return q.getAnswers();
    }
}
