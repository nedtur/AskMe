/**
 *
 * The MIT License
 *
 * Copyright (c) 2008 the original author or authors.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:

 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.

 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.hist.askme.beans;

import com.googlecode.charts4j.Color;
import static com.googlecode.charts4j.Color.*;
import com.googlecode.charts4j.GCharts;
import com.googlecode.charts4j.PieChart;
import com.googlecode.charts4j.Slice;
import com.hist.askme.models.Question;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.ArrayList;

@ManagedBean
@SessionScoped
public class Charts implements Serializable {

    ArrayList<Slice> list;
    String[] colors = {"FF1155", "33DD55", "3355FF"};
    int colorCount = 0;
    
    
    
    public Charts(){
    list = new ArrayList<Slice>();

    }
    
    public void updatePiece(){
    }
    
    public String setPiece(Question q){
        for (int i = 0; i<q.getOptions().size(); i++){
            list.add(Slice.newSlice(q.getOptions().get(i).getResult(), Color.newColor(colors[colorCount]), q.getOptions().get(i).getText(), q.getOptions().get(i).getText()));
            colorCount++;
            if(colorCount == 3){
                colorCount = 0;
            }
        }
        
        PieChart chart = GCharts.newPieChart(list);
        chart.setTitle(q.getQuestionText(), BLACK, 16);
        chart.setSize(500, 200);
        chart.setThreeD(true);
        
        String url = chart.toURLString();
        list.clear();
        colorCount=0;
        return url;
        
       
    }

    /*
        public void setPiece(String answer, int numberOfAnswered) {
        list.add(Slice.newSlice(numberOfAnswered, Color.newColor(colors[colorCount]), answer, answer));
        colorCount++;
    }
     * 
     */
    
    /*
    public String createChart(String question) {
        
        PieChart chart = GCharts.newPieChart(list);
        chart.setTitle(question, BLACK, 16);
        chart.setSize(500, 200);
        chart.setThreeD(true);
        String url = chart.toURLString();
        return url;
    }
     * 
     */
    
    /*
    public String getPieChart() {
        Slice s1 = Slice.newSlice(30, Color.newColor("CACACA"), "Safari", "Apple");
        Slice s2 = Slice.newSlice(30, Color.newColor("DF7417"), "Firefox", "Mozilla");
        Slice s3 = Slice.newSlice(30, Color.newColor("951800"), "Chrome", "Google");
        Slice s4 = Slice.newSlice(10, Color.newColor("01A1DB"), "Internet Explorer", "Microsoft");

        PieChart chart = GCharts.newPieChart(s1, s2, s3, s4);
        chart.setTitle("A Better Web", BLACK, 16);
        chart.setSize(500, 200);
        chart.setThreeD(true);
        String url = chart.toURLString();
        return url;
    }
    
     * #FF1155 //rosa
     * #33DD55 //grønn
     * #3355FF //blå
     * 
    */
}
