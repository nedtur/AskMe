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
    
    Questionnaire questionnaire = new Questionnaire();
    ArrayList<Question> questions = questionnaire.getQuestions(); 
    
    public ArrayList<Question> getQuestions() {
        return questions;
    }
    public void addQuestion(Question q) {
        questionnaire.addQuestion(q);
    }
    public void deleteQuestion(Question q) {
        questionnaire.deleteQuestion(q);
    }
}
