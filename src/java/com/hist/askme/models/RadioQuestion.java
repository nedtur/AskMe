/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hist.askme.models;

import java.util.ArrayList;

/**
 *
 * @author Håvard
 */
public class RadioQuestion extends Question{
    public RadioQuestion(String question, int amountOfAnswers, ArrayList<String> answers) {
        super(question, amountOfAnswers, answers);
    }
}
