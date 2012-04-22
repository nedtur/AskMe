/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hist.askme.models;

import java.util.UUID;

/**
 *
 * @author Ina
 */
public class RadioMultipleAnswer extends MultipleAnswer {
    Answer answer;
    
    public RadioMultipleAnswer(UUID questionID){
        super(questionID);
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }
    
}
