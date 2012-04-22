/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hist.askme.models;

import java.util.List;

/**
 *
 * @author Ina
 */
public class RadioQuestion extends MultipleChoiceQuestion {
    Answer answer;

    public RadioQuestion(String questiontext, List<Answer> answers) {
        super(questiontext, answers);
    }
    
    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }
    
}
