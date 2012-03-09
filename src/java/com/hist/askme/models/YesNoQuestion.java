/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hist.askme.models;
/**
 *
 * @author Håvard
 */

public class YesNoQuestion extends Question {
 
    public YesNoQuestion(String question, int amountOfAnswers, String[] answers) {
        super(question, amountOfAnswers, answers);
        amountOfAnswers = 2;
        answers = new String[]{"yes", "no"};
    }
}
