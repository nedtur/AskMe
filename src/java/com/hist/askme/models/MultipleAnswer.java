/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hist.askme.models;

import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author Håvard
 */
public class MultipleAnswer extends Answer {

    private ArrayList<String> theAnswers = new ArrayList<String>();
    

    public MultipleAnswer(UUID questionID) {
        super(questionID);
    }

    public void addAnswer(String newAnswer) {
        theAnswers.add(newAnswer);
    }

    public int getNumberOfAnswers() {
        return theAnswers.size();
    }

    public ArrayList<String> getAnswers() {
        return theAnswers;
    }
}
