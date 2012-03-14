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
    String que;
    String ans;
    int amountofanswers = 2;
    ArrayList<String> answers = new ArrayList<String>();
    
    public QuestionBean() {
        answers.add("yes");
        answers.add("no");
        questions.add(new Question("hei", 2, answers));
        questions.add(new Question("grei", 2, answers));
        questions.add(new Question("nei", 2, answers));
    }
    
    public ArrayList<Question> getQuestions() {
        return questions;
    }
    public void addQuestion() {
        questions.add(new Question(que, amountofanswers, answers));
    }
    
    public String getQue() { return que;}
    public void setQue(String newQue) { que = newQue;}
    public String getAns() { return ans;}
    public void setAns(String a) { ans=a; }
    public int getAmount() { return amountofanswers;}
    public void setAmount(int newAmount){ amountofanswers = newAmount;}
    public ArrayList<String> getAnswers() { return answers;}
    public void addAnswer(){ answers.add(ans); amountofanswers++;}
    public void deleteAnswer(String delAns) {
        for(String a : answers) {
            if(a.equalsIgnoreCase(delAns)) {
                answers.remove(a);
                amountofanswers--;
            }
        }
    }
}
