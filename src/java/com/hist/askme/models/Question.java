package com.hist.askme.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Question implements Serializable {

    public final static int CHECKBOX_QUESTION = 0;
    public final static int RADIO_QUESTION = 1;
    public final static int BOOLEAN_QUESTION = 2;
    public final static int TEXT_QUESTION = 3;
    @Id
    private String questionText;
    @OneToMany(mappedBy = "question", cascade = CascadeType.PERSIST)
    private List<Answer> options = new ArrayList<Answer>();
    @Transient
    private String answer;
    @ManyToOne
    private Questionnaire questionnaire;

    public Question() {}
    public Question(String questionText, List<Answer> options) {
        this.questionText = questionText;
        this.options = options;
    }

    public Answer getOptionByString(String ans) {
        for (Answer a : options) {
            if (a.getText().compareTo(ans) == 0) {
                return a;
            }
        }
        return null;
    }

    public String getQuestionText() {
        return questionText;
    }

    public List<Answer> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<Answer> options) {
        this.options = options;
    }

    public Questionnaire getQuestionnaire() {
        return questionnaire;
    }

    public void setQuestionnaire(Questionnaire questionnaire) {
        this.questionnaire = questionnaire;
    }

    public int amountOfAnswered() {
        int amountOfAnswered = 0;
        for (int i = 0; i < options.size(); i++) {
            amountOfAnswered += options.get(i).getResult();
        }
        return amountOfAnswered;

    }

    public int getAmountOfOptions() {
        return options.size();
    }

    public void setQuestionText(String newQ) {
        questionText = newQ;
    }

    public void addOption(String answer) {
        Answer a = new Answer(answer);
        a.setQuestion(this);
        options.add(a);
    }

    public void deleteOption(Answer answer) {
        options.remove(answer);
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getQuestionType() {
        return "Type:" + this.getClass();
    }

    public int getQuestionInt() {
        return 4;
    }

    public void addTextAnswer(String answer) {
    }

    public List<String> getTextAnswers() {
        return null;
    }
}
