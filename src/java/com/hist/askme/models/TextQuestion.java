package com.hist.askme.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
public class TextQuestion extends Question {
    @OneToMany(mappedBy="textQuestion", cascade=CascadeType.PERSIST)
    private List<TextEntity> textAnswers = new ArrayList<TextEntity>();
    
    public TextQuestion() {}
    public TextQuestion(String questiontext) {
        super(questiontext, null);
    }
    @Override
    public void fixOptions() {
        for(TextEntity t : textAnswers) {
            t.setTextQuestion(this);
        }
    }
    
    @Override
    public List<Answer> getOptions() {
        List<Answer> liste = new ArrayList<Answer>();
        liste.add(new Answer("Text"));
        return liste;
    }
    
    @Override
    public int getQuestionInt(){
        return Question.TEXT_QUESTION;
    }
    
    @Override
    public void addTextAnswer(TextEntity answer) {
        textAnswers.add(answer);
    }
    
    @Override
    public List<TextEntity> getTextAnswers() {
        return textAnswers;
    }
}
