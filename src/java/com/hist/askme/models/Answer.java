package com.hist.askme.models;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Answer implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String text;
    private int resultInt;
    @ManyToOne
    private Question question;

    public Answer() {
    }

    public Answer(String text) {
        this.text = text;
        resultInt = 0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getResult() {
        return resultInt;
    }

    public void setResult() {
        resultInt++;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

}
