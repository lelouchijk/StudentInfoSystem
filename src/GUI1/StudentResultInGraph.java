package GUI1;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class StudentResultInGraph extends JFrame {
	
	static ArrayList <Student> studentlist;
	  private int scrWidth, scrHeight, frameWidth = 700, frameHeight = 500,x,y;
	    DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
	   
	   
	    
	    public StudentResultInGraph(Student std) {
	    	setVisible(true);
	        setTitle("Result In Graph");
	        scrWidth =(int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	        scrHeight =(int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	        x = scrWidth/2 - frameWidth/2;
	        y = scrHeight/2 - frameHeight/2;
	        setLocation(x,y);
	        setSize(frameWidth,frameHeight);
	        setLayout(new FlowLayout(FlowLayout.LEFT));
	        getContentPane().setBackground(Color.white);
	        setData();
	        int index = studentlist.indexOf(std);
            std = studentlist.get(index);
	        JFreeChart  lineChart = ChartFactory.createLineChart(
		            std.getName()+" 's Analysis",
		            "Assignment Units", "Grades",
		            dataset,
		            PlotOrientation.VERTICAL,
		            true, true, false);
	        ChartPanel chartPanel = new ChartPanel( lineChart );
	        CategoryPlot plot = (CategoryPlot) lineChart.getPlot();
	        NumberAxis yAxis = new NumberAxis("Grades");
	        yAxis.setRange(1, 110);
	        plot.setRangeAxis(yAxis);
	        String series1 = "Assignments result";
            ArrayList<Assignment> assignments = std.getAssignmentList();
            for (Assignment ass : assignments) {
                String rowKey = Integer.toString(ass.getUnitNumber());
                int grade = 0;
                if (ass.getGrade().equalsIgnoreCase("p"))
                    grade = 64;
                else if(ass.getGrade().equalsIgnoreCase("m"))
                    grade = 79;
                else if(ass.getGrade().equalsIgnoreCase("d"))
                    grade = 100;
                dataset.addValue(grade, series1, rowKey);
            }
            add(chartPanel);
	    }
	
	
	public static void setData() {
		ReadStudentsFromJson studentReader = new ReadStudentsFromJson();
        studentlist = studentReader.getStudentList();
       
        
	}

}
