package com.hist.askme.models;

import java.io.Serializable;
import javax.persistence.*;


@Entity
public class TextEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String text;
    @ManyToOne
    private Question textQuestion;
    
    public TextEntity() {}
    public TextEntity(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Question getTextQuestion() {
        return textQuestion;
    }

    public void setTextQuestion(Question textQuestion) {
        this.textQuestion = textQuestion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TextEntity)) {
            return false;
        }
        TextEntity other = (TextEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hist.askme.models.textEntity[ id=" + id + " ]";
    }
    
}
