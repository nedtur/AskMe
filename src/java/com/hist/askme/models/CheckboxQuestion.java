/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hist.askme.models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ina
 */
public class CheckboxQuestion extends Question {
    private ArrayList<Answer> answers = new ArrayList<Answer>();

    public CheckboxQuestion(String questiontext, List<Answer> answers) {
        super(questiontext, answers);
    }
    
    public void addAnswer(Answer answer) {
        this.answers.add(answer);
    }
    
    public void removeAnswer(Answer answer) {
        this.answers.remove(answer);
    }
    
    public ArrayList<Answer> getAnswers() {
        return answers;
    }
    
    @Override
    public Answer getAnswer(){
        throw new UnsupportedOperationException();
    }
    
    @Override
    public void setAnswer(Answer answer){
        throw new UnsupportedOperationException();
    }
    
}
