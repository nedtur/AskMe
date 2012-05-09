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
    String[] colors = {"DF0000", "FF8000", "FFFF00", "00FF00", "0000FF", "0000AF", "50007F", "FF1155"};
    
    int colorCount = 0;
    
    
    
    public Charts(){
    list = new ArrayList<Slice>();

    }
    
    public void updatePiece(){
    }
    
    public String setPiechart(Question q){
        for (int i = 0; i<q.getOptions().size(); i++){
            list.add(Slice.newSlice(q.getOptions().get(i).getResult(), Color.newColor(colors[colorCount]), q.getOptions().get(i).getText(), q.getOptions().get(i).getText()));
            colorCount++;
            if(colorCount == 7){
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
}
