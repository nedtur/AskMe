/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hist.askme.models;

import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author Ina
 */
public class CheckboxMultipleAnswer extends MultipleAnswer {
    private ArrayList<Answer> answers = new ArrayList<Answer>();
    
    public void addAnswer(Answer answer) {
        this.answers.add(answer);
    }
    
    public void removeAnswer(Answer answer) {
        this.answers.remove(answer);
    }
    
    public void setAnswers(ArrayList<Answer> answers) {
        this.answers = answers;
    }

    public CheckboxMultipleAnswer(UUID questionID) {
        super(questionID);
    }

    public ArrayList<Answer> getAnswers() {
        return answers;
    }
}
