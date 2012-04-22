/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hist.askme.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author Ina
 */
public class CheckboxQuestion extends MultipleChoiceQuestion {
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
    
    public void setAnswers(ArrayList<Answer> answers) {
        this.answers = answers;
    }

    public ArrayList<Answer> getAnswers() {
        return answers;
    }
}
