package com.hist.askme.models;

import java.util.List;
import javax.persistence.*;

@Entity
@DiscriminatorValue("1")
public class RadioQuestion extends Question {
    public RadioQuestion() {}
    public RadioQuestion(String questiontext, List<Answer> answers) {
        super(questiontext, answers);
    }
    
    @Override
    public int getQuestionInt() {return Question.RADIO_QUESTION;}
}
