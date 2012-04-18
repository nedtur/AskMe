/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hist.askme.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Ina
 */
@ManagedBean
@RequestScoped
public class GenerateComponents {

    public formTitle  = "";

    public GenerateComponents() {
    }

    public String getFormTitle() {
        return formTitle;
    }

    public void setFormTitle(String formTitle) {
        this.formTitle = formTitle;
    }
}
