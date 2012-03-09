/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hist.askme.beans;

import com.hist.askme.models.Question;
import java.util.ArrayList;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;



/**
 *
 * @author Håvard
 */
@ManagedBean
@SessionScoped
public class QuestionBean {
    String [] svar = {"Ja","Nei"};
    ArrayList<Question> questions = new ArrayList<Question>();
    Question question = new Question("Funker dette?", 2, svar);
    String out = question.getQuestion();
    
    public Question getQuestion() {
        return question;
    }
    
    public String getOut() {
        return out;
    }
}