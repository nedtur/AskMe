package com.hist.askme.beans;

import com.hist.askme.models.Question;
import com.hist.askme.models.Questionnaire;
import com.hist.askme.models.QuestionnaireService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean
@SessionScoped
public class QuestionnaireBean implements Serializable {

    String name = "ID" + new Random().nextInt(9999);
    int pubTime = 0;
    Questionnaire questionnaire = new Questionnaire();
    ArrayList<Question> questions = new ArrayList<Question>();
    QuestionnaireService questionnaireService = new QuestionnaireService();
    ArrayList<Questionnaire> questionnaires = questionnaireService.getQuestionnaires();
    boolean hasAnswered = false;
    boolean isPublished = false;
    String link = "askme.hist.no";
    

    public boolean getIsPublished(){
        return isPublished;
    }
    public QuestionnaireService getQuestionnaireService() {
        return questionnaireService;
    }

    public void setQuestionnaireService(QuestionnaireService qs) {
        questionnaireService = qs;
    }

    public ArrayList<Questionnaire> getQuestionnaires() {
        return questionnaires;
    }

    public void addQuestionnaire(Questionnaire q) {
        questionnaireService.addQuestionnaire(q);
        isPublished=true;
    }

    public void deleteQuestionnaire(Questionnaire q) {
        questionnaireService.deleteQuestionnaire(q);
    }

    public Questionnaire newQuestionnaire() {
        questionnaire = new Questionnaire(name, questions);
        questions = new ArrayList<Question>();
        return questionnaire;
    }

    public String getName() {
        return name;
    }
    
    public String getLink(){
        return link+"/"+name;
    }

    public void setName(String newName) {
        name = newName;
    }

    public int getPubTime() {
        return pubTime;
    }

    public void setPubTime(int newTime) {
        pubTime = newTime;
    }

    public Questionnaire getQuestionnaire() {
        return questionnaire;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void addQuestion(Question q) {
        questions.add(q);
    }

    public void deleteQuestion(Question q) {
        questions.remove(q);
    }

    public String answerQuestionnaire() {
        if (IPAlreadyUsed()) {
            return "pretty:questionnaire";
        } else {
            for (Question q : questionnaire.getQuestions()) {
                if (q.getQuestionInt() == 3) {
                    q.addTextAnswer(q.getAnswer());
                } else {
                    q.getOptionByString(q.getAnswer()).setResult();
                }
            }
            return "pretty:result";
        }
    }
        

    public String getUserIP() {
        HttpServletRequest httpServletRequest = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        return httpServletRequest.getRemoteAddr();
    }
    
    public void setUserIP(){
        questionnaire.setUserIP(getUserIP());
        
    }
    
    public boolean getHasAnswered(){
        return hasAnswered;
        
    }
    
    public boolean IPAlreadyUsed() {

        for (int i = 0; i<questionnaire.getIPList().size(); i++){
            if (questionnaire.getIPList().get(i).equals(getUserIP())){
                hasAnswered=true;
            return true;
            } 
        }
        setUserIP();
        return false;

    }

    //-----------------------------------------------------------------------------
    public void init() {
        if (name.trim() == null) {
            String message = "Bad request. Please use a link from within the system.";
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));
            return;
        }
        questionnaire = questionnaireService.find(name);

        if (questionnaire == null) {
            String message = "Bad request. Unknown questionnaire.";
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));
            return;
        }
    }
}
