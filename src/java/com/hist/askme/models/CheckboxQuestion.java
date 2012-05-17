
package com.hist.askme.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

public class CheckboxQuestion extends Question {
    private ArrayList<Answer> answers = new ArrayList<Answer>();
    
    public CheckboxQuestion() {}
    public CheckboxQuestion(String questiontext, List<Answer> answers) {
        super(questiontext, answers);
    }
    
    public void addAnswer(Answer answer) {
        this.answers.add(answer);
    }
    
    public void removeAnswer(Answer answer) {
        this.answers.remove(answer);
    }
    
    public ArrayList<Answer> getAnswers() {
        return answers;
    }
    
    @Override
    public String getAnswer(){
        throw new UnsupportedOperationException();
    }
    
    @Override
    public void setAnswer(String answer){
        throw new UnsupportedOperationException();
    }
    @Override
    public int getQuestionInt() {return Question.CHECKBOX_QUESTION;}
}
