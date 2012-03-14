/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hist.askme.beans;

import com.hist.askme.models.Question;
import java.util.ArrayList;
import java.util.Arrays;
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
    String selected = "Hei";
    private Set<String> types = new TreeSet<String>();
    public static final ArrayList<String> responseTypes = new ArrayList<String>();

    public QuestionBean() {

        responseTypes.add("Ja/Nei");
        responseTypes.add("Flervalg");
        responseTypes.add("Tekst");

    }
    
    public ArrayList getResponseTypes(){
        return responseTypes;
    }
    
    public String testSTRING = "spørsmålsTEST";
    int testINT = 6;

    public String getTestString() {
        return testSTRING;
    }
    
    public String getSelected(){
        return selected;
    }

     public void setSelected(String ny){
        selected = ny;
    }
    
    public int getTestInt() {
        return testINT;
    }

    public void setTestInt(int ny) {
        testINT = ny;
    }

    public void setTestString(String ny) {
        testSTRING = ny;
    }

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

    public String submit() {
        return "questionnaire";
    }
    final static String[] stringArray = {"tester her", "test", "hei"};
    public static final ArrayList<Question> questionlist =
            new ArrayList<Question>(Arrays.asList(
            new Question("Spørsmål her", 3, stringArray)));

    public String addAction() {

        Question questionme = new Question(this.testSTRING, this.testINT,
                this.svar);

        questionlist.add(questionme);
        return null;
    }

    public String deleteAction(Question question) {

        questionlist.remove(question);
        return null;
    }

    public ArrayList<Question> getQuestionlist() {

        return questionlist;

    }
}
