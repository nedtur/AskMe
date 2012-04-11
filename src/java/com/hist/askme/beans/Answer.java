/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hist.askme.beans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlBody;
import javax.faces.component.html.HtmlForm;

/**
 *
 * @author Ina
 */
@ManagedBean
@SessionScoped
public class Answer implements Serializable {

    private HtmlForm textForm;
    private HtmlForm radioForm;
    private HtmlForm checkForm;

    public Answer() {
        textForm = new HtmlForm();
        radioForm = new HtmlForm();
        checkForm = new HtmlForm();
    }
    
    private HtmlForm getTextForm(String question){
        return textForm;
    }
    
    private HtmlForm getRadioForm(String question){
        return radioForm;
    }
    
    private HtmlForm getCheckForm(String question){
        return checkForm;
    }
}
