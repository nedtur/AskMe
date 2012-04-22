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
 * @author Håvard
 */
public class MultipleChoiceQuestion extends Question {

    private ArrayList<Answer> theOptions = new ArrayList<Answer>();

    public MultipleChoiceQuestion(String question, List<Answer> answers) {
        super(question, answers);
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
