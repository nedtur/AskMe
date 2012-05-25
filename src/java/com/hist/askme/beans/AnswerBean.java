package com.hist.askme.beans;

import com.hist.askme.models.Question;
import com.hist.askme.models.Questionnaire;
import com.hist.askme.models.QuestionnaireService;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean
@SessionScoped
public class AnswerBean implements Serializable{
    private Questionnaire questionnaire = new Questionnaire();
    private String name = "";
    private ArrayList<Questionnaire> questionnaires;
    private QuestionnaireService questionnaireService = new QuestionnaireService();
    private boolean noQuestionnaire = false;
    private boolean hasAnswered;
    private boolean answerSuccess;
    private String link = "askme.hist.no/";

    public String getLink() {
        return link + questionnaire.getName();
    }

    public void setLink(String link) {
        this.link = link;
    }

    public boolean isAnswerSuccess() {
        return answerSuccess;
    }

    public void setAnswerSuccess(boolean answerSuccess) {
        this.answerSuccess = answerSuccess;
    }

    public boolean isHasAnswered() {
        return hasAnswered;
    }

    public void setHasAnswered(boolean hasAnswered) {
        this.hasAnswered = hasAnswered;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isNoQuestionnaire() {
        return noQuestionnaire;
    }

    public void setNoQuestionnaire(boolean noQuestionnaire) {
        this.noQuestionnaire = noQuestionnaire;
    }

    public Questionnaire getQuestionnaire() {
        return questionnaire;
    }

    public void setQuestionnaire(Questionnaire questionnaire) {
        this.questionnaire = questionnaire;
    }

    public QuestionnaireService getQuestionnaireService() {
        return questionnaireService;
    }

    public void setQuestionnaireService(QuestionnaireService questionnaireService) {
        this.questionnaireService = questionnaireService;
    }

    public ArrayList<Questionnaire> getQuestionnaires() {
        return questionnaires;
    }

    public void setQuestionnaires(ArrayList<Questionnaire> questionnaires) {
        this.questionnaires = questionnaires;
    }
    
    public void endSession() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

    }
    
    public String answerQuestionnaire() {
        if (IPAlreadyUsed()) {
            return "";
        } else {
            for (Question q : questionnaire.getQuestions()) {
                if (q.getQuestionInt() == Question.TEXT_QUESTION) {
                    questionnaireService.updateTextQuestionnaire(q);
                } else if (q.getQuestionInt() == Question.CHECKBOX_QUESTION) {
                    if(q.getAnswers() != null) {
                        questionnaireService.updateCheckboxQuestionnaire(q.getAnswers());
                    }
                } else {
                    if(q.getAnswer() == null) {
                        return "";
                    }
                    questionnaireService.updateQuestionnaire(q.getAnswer());
                }
            }
            setUserIP();
            answerSuccess=true;
            return "";
        }
    }
    public String getUserIP() {
        HttpServletRequest httpServletRequest = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        return httpServletRequest.getRemoteAddr();
    }

    public void setUserIP() {
        questionnaireService.setUserIP(getUserIP(), questionnaire);

    }
    
    public boolean IPAlreadyUsed() {
        for (int i = 0; i < questionnaire.getIPList().size(); i++) {
            if (questionnaire.getIPList().get(i).getIp().equals(getUserIP())) {
                hasAnswered = true;
                return true;
            }
        }
        return false;

    }
    
    public void init() {
        if (name.trim() == null) {
            String message = "Bad request. Please use a link from within the system.";
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));
            return;
        }
        if (questionnaire == null) {
            questionnaire = new Questionnaire("123", null);
        }
        questionnaire = questionnaireService.find(name, questionnaireService.getQuestionnaires());
        
        if (questionnaire == null) {
            noQuestionnaire = true;
            return;
        }
    }
}
