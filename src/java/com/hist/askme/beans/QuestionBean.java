/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hist.askme.beans;

import com.hist.askme.models.*;
import java.util.ArrayList;
import java.io.Serializable;
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
    List<Answer> answers = new ArrayList<Answer>();
    String selected = "0";
    String yesOrNo = "whoknows";

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question newQ) {
        question = newQ;
    }

    public String getQuestiontext() {
        return questiontext;
    }

    public void setQuestiontext(String newQ) {
        questiontext = newQ;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String newA) {
        ans = newA;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public Question newQuestion() {
        switch (Integer.parseInt(selected))  {
            case Question.BOOLEAN_QUESTION:
                question = new BooleanQuestion(questiontext);
                break;
            case Question.CHECKBOX_QUESTION:
                question = new CheckboxQuestion(questiontext, answers);
                break;
            case Question.RADIO_QUESTION:
                question = new RadioQuestion(questiontext, answers);
                break;
            case Question.TEXT_QUESTION:
                question = new TextQuestion(questiontext);
                break;
        }
        answers = new ArrayList<Answer>();
        return question;
    }

    public void addAnswer() {
        Answer a = new Answer(ans);
        answers.add(a);
    }

    public void deleteAnswer(Answer answer) {
        answers.remove(answer);
    }

    public String getSelected() {
        return selected;
    }

    public void setSelected(String newSelected) {
        selected = newSelected;
    }

    public boolean getYesNoAnswer() {
        return (selected.equals("2"));
    }

    public boolean getTextAnswer() {
        return (selected.equals("3"));
    }

    public boolean getMultipleChoiceQuestion() {
        return (selected.equals("1")||selected.equals("0"));
    }
    
    
    //tester databasen.. 
    public String getDatabase(){
        
        return"";
    }
}
