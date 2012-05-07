/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hist.askme.models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Håvard
 */
public class Question {

    public final static int CHECKBOX_QUESTION = 0;
    public final static int RADIO_QUESTION = 1;
    public final static int BOOLEAN_QUESTION = 2;
    public final static int TEXT_QUESTION = 3;
        
    private String questionText;
    private List<Answer> options = new ArrayList<Answer>();
    private String answer;

    public Question() {
    }
    public Question(String question, List<Answer> options) {
        this.questionText = question;
        this.options = options;
    }
    
    public Answer getOptionByString(String ans) {
        for(Answer a : options){
            if(a.getText().compareTo(ans) == 0) {
                return a;
            }
        }
        return null;
    }

    public String getQuestionText() {
        return questionText;
    }

    public List<Answer> getOptions() {
        return options;
    }
    
    public int getAmountOfOptions(){
        return options.size();
    }

    public void setQuestionText(String newQ) {
        questionText = newQ;
    }

    public void setOptions(ArrayList<Answer> newAns) {
        options = newAns;
    }

    public void addOption(String answer) {
        options.add(new Answer(answer));
    }

    public void deleteOption(Answer answer) {
        options.remove(answer);
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer){
        this.answer = answer;
    }

    public String getQuestionType() {
        return "Type:" + this.getClass();
    }
    public int getQuestionInt() {
        return 4;
    }
}
