/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hist.askme.models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author christian
 */
public class TextQuestion extends Question {

    public TextQuestion(String questiontext) {
        super(questiontext, null);
    }
    
    @Override
    public List<Answer> getOptions() {
        List<Answer> liste = new ArrayList<Answer>();
        liste.add(new Answer("Text"));
        return liste;
    }
    
}
