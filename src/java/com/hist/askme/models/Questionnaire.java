                                                                                                /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hist.askme.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;


@Entity
public class Questionnaire implements Serializable {
    @Id
    private String name;
    @OneToMany(mappedBy="questionnaire", cascade=CascadeType.PERSIST)
    private ArrayList<Question> questions = new ArrayList<Question>();
    @Transient
    ArrayList<String> IP = new ArrayList<String>();
    
      
    public void setUserIP(String UserIP){
        IP.add(UserIP);
    }
    public ArrayList<String> getIPList(){
        return IP;
    }
    
    public Questionnaire() {}
    
    public Questionnaire(String name, ArrayList<Question> questions) {
        this.name = name;
        this.questions = questions;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String nName) {
        name = nName;
    }
    
    public void setQuestions(ArrayList<Question> qs) {
        questions = qs;
    }
    
    public ArrayList<Question> getQuestions() {
        return questions;
    }
    public Question getQuestionByString(String question) {
        for(Question q : questions) {
            if(q.getQuestionText().equalsIgnoreCase(question)) {
                return q;
            }
        }
        return null;
    }
    public Question getQuestionById(int id) {
        return questions.get(id);
    }    
    public void addQuestion(Question question){
        question.setQuestionnaire(this);
        questions.add(question);
    }
    public void deleteQuestion(Question question) {
        questions.remove(question);
    }
    public void addAnswer(Question q, String answer) {
        q.addOption(answer);
    }
    public void deleteAnswer(Question q, Answer answer) {
        q.deleteOption(answer);
    }
    public List<Answer> getAnswers(Question q) {
        return q.getOptions();
    }

}

