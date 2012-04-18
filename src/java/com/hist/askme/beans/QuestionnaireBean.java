/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hist.askme.beans;

import com.hist.askme.models.Question;
import com.hist.askme.models.Questionnaire;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Håvard
 */
@ManagedBean
@SessionScoped
public class QuestionnaireBean implements Serializable {
    
    String name = "";
    int pubTime = 0;
    Questionnaire questionnaire = new Questionnaire(name, pubTime);
    ArrayList<Question> questions = questionnaire.getQuestions();
    ArrayList<Questionnaire> questionnaires = new ArrayList <Questionnaire>();
    ArrayList<Questionnaire> questionnairesActive = new ArrayList <Questionnaire>();
    ArrayList<QuestionBean> qs = new ArrayList<QuestionBean>();
    
    public String getName() { return name; }
    public void setName(String newName) { name = newName; }
    public int getPubTime() { return pubTime; }
    public void setPubTime(int newTime) {  pubTime = newTime; }
    
    public ArrayList<Question> getQuestions() {
        return questions;
    }
    public void addQuestion(Question q) {
        questionnaire.addQuestion(q);
    }

    public void deleteQuestion(Question q) {
        questionnaire.deleteQuestion(q);
    }
    
    public ArrayList<Questionnaire> getQuestionnaires() {
        return questionnaires;
    }
    public ArrayList<Questionnaire> getQuestionnairesActive() {
        for (Questionnaire q : getQuestionnaires()) {
            if(q.getPublished()) {
                questionnairesActive.add(q);
            }
        }
        return questionnairesActive;
    }
    
    public boolean publishQuestionnaire() {
        questionnaire.publish();
        return true;
    }
    
    public String answerQuestionnaire() {
        for(Question q : questions) {
            q.answerAns(null);
        }
        return "result.xhtml";
    }
    
}
