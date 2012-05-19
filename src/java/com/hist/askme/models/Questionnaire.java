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
    private List<Question> questions = new ArrayList<Question>();
    @OneToMany(mappedBy="questionnaire", cascade=CascadeType.PERSIST)
    private List<IpEntity> IP = new ArrayList<IpEntity>();
          
    public void setUserIP(String UserIP){
        IP.add(new IpEntity(UserIP, this));
    }
    public List<IpEntity> getIPList(){
        return IP;
    }
    
    public Questionnaire() {}
    
    public Questionnaire(String name, ArrayList<Question> questions) {
        this.name = name;
        this.questions = questions;
    }
    
    public void fixQuestions() {
        for(Question q : questions) {
            q.setQuestionnaire(this);
        }
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
    
    public List<Question> getQuestions() {
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
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (name != null ? name.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Questionnaire)) {
            return false;
        }
        Questionnaire other = (Questionnaire) object;
        if ((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Questionnaire[ id=" + name + " ]";
    }

}

