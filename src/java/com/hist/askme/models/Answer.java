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
public class Answer {
    
    UUID questionID;
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    public Answer(String text) {
        this.text = text;
    }
    
    public Answer(UUID questionID){
        this.questionID = questionID;
    }
    
}
