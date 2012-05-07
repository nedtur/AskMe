/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hist.askme.models;

import java.util.ArrayList;

public class BooleanQuestion extends Question {

    public BooleanQuestion(String questiontext) {
        super(questiontext, null);
        ArrayList<Answer> yesno = new ArrayList<Answer>();
        yesno.add(new Answer("Ja"));
        yesno.add(new Answer("Nei"));        
        super.setOptions(yesno);
    }
 
    @Override
    public int getQuestionInt() {return Question.BOOLEAN_QUESTION;}
}