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
public class CheckboxQuestion extends Question{
    public CheckboxQuestion(String question, int amountOfAnswers, ArrayList<String> answers) {
        super(question, amountOfAnswers, answers);
    }
}
