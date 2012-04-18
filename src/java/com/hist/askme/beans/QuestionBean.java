/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hist.askme.beans;

import com.hist.askme.models.Question;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Håvard
 */

@ManagedBean
@SessionScoped
public class QuestionBean implements Serializable {
    
    Question question = new Question();
    String questiontext = "Spørsmål...";
    String ans = "Svar...";
    List<com.hist.askme.models.Answer> answers = new ArrayList<com.hist.askme.models.Answer>();
    String selected = "0";
    String yesOrNo = "whoknows";
    com.hist.askme.models.Answer selectedAnswer;
    
    public Question getQuestion() { return question; }
    public void setQuestion(Question newQ) { question = newQ; }
    public String getQuestiontext() { return questiontext; }
    public void setQuestiontext(String newQ) { questiontext = newQ; }
    public String getAns() { return ans; }
    public void setAns(String newA) { ans = newA; }
    public List<com.hist.askme.models.Answer> getAnswers() { return answers; }
    
    public Question newQuestion() {
        question = new Question(questiontext, answers);
        answers = new ArrayList<com.hist.askme.models.Answer>();
        return question;
    }
    
    public String addAnswer() {
        com.hist.askme.models.Answer a = new com.hist.askme.models.Answer(ans);
        answers.add(a);
        return null;
    }
    public String deleteAnswer(com.hist.askme.models.Answer answer) {
        answers.remove(answer);
        return null;
    }
    
    public String getSelected(){
        return selected;
    }
    public void setSelected(String newSelected){
        selected = newSelected;
    }
    public boolean getYesNoAnswer(){
        if (selected.equals("1")){
            return true;
        } else {
        return false;
        }
    }
    public boolean getTextAnswer(){
        if (selected.equals("2")){
            return true;
        } else {
        return false;
        }
    }
    public boolean getMultipleAnswer(){
        if (selected.equals("3")){
            return true;
        } else {
        return false;
        }
    }
    
    public com.hist.askme.models.Answer getSelectedAnswer() { return selectedAnswer;}
    public void setSelectedAnswer(com.hist.askme.models.Answer ans) { selectedAnswer = ans; }
    
    
}
