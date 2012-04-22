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

    private ArrayList<Answer> theOptions = new ArrayList<Answer>();
    

    public MultipleAnswer(UUID questionID) {
        super(questionID);
    }

    public void addOption(Answer newAnswer) {
        theOptions.add(newAnswer);
    }

    public int getNumberOfOptions() {
        return theOptions.size();
    }

    public ArrayList<Answer> getOptions() {
        return theOptions;
    }
}
