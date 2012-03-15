/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hist.askme.beans;

import com.hist.askme.models.Question;
import java.util.ArrayList;
import java.util.Arrays;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Håvard
 */
@ManagedBean
@SessionScoped
public class QuestionBean {

    static final ArrayList<Question> questions = new ArrayList<Question>();
    String question = "Spørsmål...";
    int amount = 0;
    static final ArrayList<String> answers = new ArrayList<String>();
    String ans = "Svar...";
    
    public String getQuestion() { return question; }
    public void setQuestion(String newQ) { question = newQ; }
    public int getAmount() { return amount; }
    public void setAmount(int newA) { amount = newA; }
    public String getAns() { return ans; }
    public void setAns(String newA) { ans = newA; }
    public ArrayList<String> getAnswers() { return answers; }
    
    public String addAnswer() {
        answers.add(ans);
        amount++;
        return null;
    }
    
    public String deleteAnswer(String answer) {
        answers.remove(answer);
        amount--;
        return null;
    }
    
    public String addQuestion() {
        Question q = new Question(this.question, this.amount, answers);
        questions.add(q);
        return null;
    }

    public String deleteQuestion(Question question) {
        questions.remove(question);
        return null;
    }

    public ArrayList<Question> getQuestions() {
        return questions;

    }
}
