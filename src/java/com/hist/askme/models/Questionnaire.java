/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hist.askme.models;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
/**
 *
 * @author Håvard
 */

public class Questionnaire {
    private static final ArrayList<Question> questions = new ArrayList<Question>();
    private String name;
    private boolean published;
    private Calendar start;
    private int pubTime;
    private Calendar end;
    
    public Questionnaire(String name, int pubTime) {
        this.name = name;
        start = Calendar.getInstance();
        this.pubTime = pubTime;
        end = null;
        published = false;
    }
    
    public void publish() {
        end.setTimeInMillis(start.getTimeInMillis()+(long) pubTime);
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
            if(q.getQuestionText().equalsIgnoreCase(question)) {
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
        q.addOption(answer);
    }
    public void deleteAnswer(Question q, Answer answer) {
        q.deleteOption(answer);
    }
    public List<Answer> getAnswers(Question q) {
        return q.getOptions();
    }
}
