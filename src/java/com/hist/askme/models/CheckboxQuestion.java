package com.hist.askme.models;

import java.util.List;
import javax.persistence.*;

@Entity
public class CheckboxQuestion extends Question {
    
    public CheckboxQuestion() {}
    public CheckboxQuestion(String questiontext, List<Answer> options) {
        super(questiontext, options);
    }
    
    @Override
    public int getQuestionInt() {return Question.CHECKBOX_QUESTION;}
}
