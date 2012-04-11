/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hist.askme.beans;

import com.hist.askme.models.Question;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Håvard
 */

@ManagedBean(name="questionBean")
@SessionScoped
public class QuestionBean implements Serializable {

    static ArrayList<Question> questions = new ArrayList<Question>();
    String question = "Spørsmål...";
    int amount = 0;
    static List<String> answers = new CopyOnWriteArrayList<String>();
    String ans = "Svar...";
    Question q = new Question(this.question, this.amount, answers);
    
    public String getQuestion() { return question; }
    public void setQuestion(String newQ) { question = newQ; }
    public int getAmount() { return amount; }
    public void setAmount(int newA) { amount = newA; }
    public String getAns() { return ans; }
    public void setAns(String newA) { ans = newA; }
   
    public List<String> getAnswers() {
        answers = q.getAnswers();
        return answers;
    }
    
    public String addAnswer() {
        q.addAnswer(ans);
        return null;
    }
    
    public String deleteAnswer(String answer) {
        q.deleteAnswer(answer);
        return null;
    }
    
    public String addQuestion() {
        questions.add(q);
        return "/answer.xhtml";
    }

    public String deleteQuestion(Question question) {
        questions.remove(question);
        return null;
    }

    public ArrayList<Question> getQuestions() {
        return questions;

    }

}
