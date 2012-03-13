/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hist.askme.beans;

import com.hist.askme.models.Question;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Håvard
 */
@ManagedBean
@SessionScoped
public class QuestionBean {

    String[] svar = {"Ja", "Nei"};
    ArrayList<Question> questions = new ArrayList<Question>();
    Question question = new Question("Funker dette?", 2, svar);
    String out = question.getQuestion();
    String name;
    String password = "ina";
    private Set<String> types = new TreeSet<String>();

    public Question getQuestion() {
        return question;
    }

    public String getOut() {
        return out;
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

    public Set<String> getTypes() {
        return types;
    }

    
    public void setTypes(Set<String> newValue) {
        types = newValue;
    }
    
}