/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hist.askme.models;

/**
 *
 * @author Ina
 */
public class Answer {

    private String text;
    private int result = 0;
    
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Answer(String text) {
        this.text = text;
    }

    public int getResult() {
        return result;
    }

    public void setResult() {
        result++;
    }
}
