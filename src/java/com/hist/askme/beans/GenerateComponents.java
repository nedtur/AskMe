/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hist.askme.beans;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.application.Application;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.context.FacesContext;

/**
 *
 * @author Ina
 */
@ManagedBean
@RequestScoped
public class GenerateComponents {

    public String formTitle = "";
    private HtmlPanelGrid gridElems = new HtmlPanelGrid();
    private HtmlPanelGrid grid;
    private Map<String, Object> keyValueMap = new HashMap<String, Object>();
    private String[] fields = {"FieldName", "FieldType", "FieldLength"};

    public GenerateComponents() {
    }

    public void setGridElems(HtmlPanelGrid gridElems) {
        this.gridElems = gridElems;
    }

    public HtmlPanelGrid getGridElems() {

        int nxtMapIndex = 0;
        Application app = FacesContext.getCurrentInstance().getApplication();

        if (grid != null) {
            System.out.println("NOT NULL");
        } else {
            grid = new HtmlPanelGrid();
        }

        grid.setColumns(6);
        List<UIComponent> children = grid.getChildren();

//    grid.setId("newGenForm:_id5");  
        if (this.keyValueMap != null) {
            nxtMapIndex = this.keyValueMap.size();
        }
        System.out.println("SIZE OF RETURNED map IS: " + nxtMapIndex);


//loop for creating input desired No. of Input fields  
        for (int rows = 0; rows < (nxtMapIndex / 3 + 1); rows++) {
            for (int i = 0; i < fields.length; i++) {
//numbering rows  
                String index;
                index = fields[i] + String.valueOf(rows) + String.valueOf(i);

                if (!this.keyValueMap.containsKey(index)) {
                    System.out.println("INDEX: " + index);
//create output fields  
                    HtmlOutputText ot = new HtmlOutputText();
                    ot.setValue(fields[i]);
                    children.add(ot);



//create input fields      
                    HtmlInputText hit = new HtmlInputText();
                    hit.setSize(30);
                    hit.setId(index);
                    hit.setTitle(index);

//Insert keys to Map   

                    this.keyValueMap.put(index, "");

//Bind input field values to Map  

                    String bind = "#{InputFieldGeneration.keyValueMap['" + index + "']}";
                    hit.setValueBinding("value", app.createValueBinding(bind));

                    hit.setRequired(true);
                    children.add(hit);
                    FacesContext.getCurrentInstance().renderResponse();
                    //With below line code solution the jsf tree is not saved among the different request-response cycles and at every new request you get a new internal tree structure.      
//    FacesContext.getCurrentInstance().getViewRoot().setTransient(true); /* where "context" is of type "FaceContext" */  
                }//end of if  
                else {
                    continue;
                }
            }
        }
        return grid;
    }

    public String checkFormGeneration() {
        System.out.println("IN Check FORM METHOD: " + keyValueMap.size());
        String logicalOutcomeStr = "";
        if (this.gridElems != null) {
            logicalOutcomeStr = "success";
        } else {
            logicalOutcomeStr = "failure";
        }
        return logicalOutcomeStr;

    }

    public String getFormTitle() {
        return formTitle;
    }

    public void setFormTitle(String formTitle) {
        this.formTitle = formTitle;
    }
}
