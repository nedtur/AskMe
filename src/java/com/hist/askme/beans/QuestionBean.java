/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hist.askme.beans;

import com.hist.askme.models.Answer;
import com.hist.askme.models.CheckboxQuestion;
import com.hist.askme.models.Question;
import com.hist.askme.models.RadioQuestion;
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
                question = new Question(questiontext, answers);
                break;
            case Question.CHECKBOX_QUESTION:
                question = new CheckboxQuestion(questiontext, answers);
                break;
            case Question.RADIO_QUESTION:
                question = new RadioQuestion(questiontext, answers);
                break;
            case Question.TEXT_QUESTION:
                question = new Question(questiontext, answers);
                break;
        }
        answers = new ArrayList<Answer>();
        return question;
    }

    public String addAnswer() {
        Answer a = new Answer(ans);
        answers.add(a);
        return null;
    }

    public String deleteAnswer(Answer answer) {
        answers.remove(answer);
        return null;
    }

    public String getSelected() {
        return selected;
    }

    public void setSelected(String newSelected) {
        selected = newSelected;
    }

    public boolean getYesNoAnswer() {
        if (selected.equals("2")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean getTextAnswer() {
        if (selected.equals("3")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean getCheckboxAnswer() {
        if (selected.equals("0")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean getRadioAnswer() {
        if (selected.equals("1")) {
            return true;
        } else {
            return false;
        }
    }

    public void ans() {
    }
}
