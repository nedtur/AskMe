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
    ArrayList<Question> questions = new ArrayList<Question>();
    String question;
    int amountofanswers;
    String[] answers = {"yes","no"};
    String name;
    String password = "ina";

    
    public String getQuestion() {
        return question;
    }
    public void setQuestion(String q) {
        question = q;
    }
    public ArrayList<Question> getQuestions() {
        return questions;
    }
    public void addQuestion() {
        amountofanswers = 2;
        Question q = new Question(question, amountofanswers, answers);
        questions.add(q);
    }
    
    public String getName() {
        return name;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setName(String newName) {
        this.name = newName;
    }
    
    public void setPassword(String newPassword) {
        this.password = newPassword;
    }
}
