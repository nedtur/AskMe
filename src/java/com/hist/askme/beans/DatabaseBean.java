package com.hist.askme.beans;

import java.sql.*;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;

/**
 *
 * @author Ina
 */
@ManagedBean
@SessionScoped
public class DatabaseBean implements Serializable {

    static String myString;

    public DatabaseBean() {

        
    }

    public void connect() {
        // TODO code application logic here
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }

        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/AskMeDatabase");
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("select * from APP.ANSWER");

            while (rs.next()) {
                String s = rs.getString("ANSWERTEXT");
                float n = rs.getInt("ANSWER_ID");
                myString = s + "   " + n;
            }
        } catch (SQLException e) {
            System.err.println(e);
        }



    }

    public String getString() {
        connect();
        return myString;
    }
    
    public void addQuestionnaire(){
    
    }
    public void addQuestion(){
    
    }
    public void addAnswer(){
    
    }
    
    
    
}
