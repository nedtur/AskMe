package com.hist.askme.models;

import java.util.ArrayList;

public class QuestionnaireService {
    private ArrayList<Questionnaire> questionnaires = new ArrayList<Questionnaire>();
    
    public QuestionnaireService() {}
    
    public ArrayList<Questionnaire> getQuestionnaires() {
        return questionnaires;
    }
    
    public void addQuestionnaire(Questionnaire qaire) {
        questionnaires.add(qaire);
    }
    public void deleteQuestionnaire(Questionnaire qaire) {
        questionnaires.remove(qaire);
    }
    
    public Questionnaire find(String name) {
        for(Questionnaire q : questionnaires) {
            if(q.getName().compareTo(name) == 0) {
                return q;
            }
        }
        return null;
    }
}
