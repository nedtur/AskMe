/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hist.askme.models;

import java.util.UUID;

/**
 *
 * @author Ina
 */
public class Answer {
    
    UUID questionID;
    
    public Answer(UUID questionID){
        this.questionID = questionID;
    }
    
}
