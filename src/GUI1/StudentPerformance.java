package GUI1;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class StudentPerformance extends JPanel {
	private JLabel lblstdID = new JLabel("Student ID");
	private JTextField txtstdID = new JTextField();
	private JButton btnShow = new JButton("Show");
	private JButton btnClear = new JButton("Clear");
	private JButton btnSChart= new JButton("Show Chart");
	private JLabel lblstdName = new JLabel("Name");
	private JTextField txtstdName = new JTextField();
	private Color orignalColor;

	private JLabel lblstdBthNum = new JLabel("Batch");
	private JTextField txtstdBthNum = new JTextField();
	
	private JLabel lblAssTotal = new JLabel("Total Assignment");
	private JTextField txtAssTotal = new JTextField();

	private JTable assignmentTable;
	private DefaultTableModel tableModel;
	private Font font1=new Font("Times New Roman", Font.PLAIN+Font.BOLD, 18);
	private Font font2=new Font("Times New Roman", Font.PLAIN+Font.BOLD, 16);
	
	private int totalAssignments ;
	private JScrollPane tableScrollPane;

	
	public StudentPerformance() {

		setLayout(null);
		orignalColor = this.getBackground();
		setBorder(new TitledBorder("Show Student Performance"));
		lblstdID.setBounds(10,30,100,30);
		lblstdID.setFont(font1);
		txtstdID.setBounds(120,30,200,30);
		txtstdID.setFont(font2);

		lblstdName.setBounds(10,130,100,30);
		lblstdName.setFont(font1);
		txtstdName.setBounds(120,130,200,30);
		txtstdName.setFont(font2);

		lblstdBthNum.setBounds(10,180,100,30);
		lblstdBthNum.setFont(font1);

		txtstdBthNum.setBounds(120,180,200,30);
		txtstdBthNum.setFont(font2);

		btnShow.setBounds(10,80,100,30);
		btnClear.setBounds(120,80,100,30);
		btnSChart.setBounds(230,80,150,30);
		
		lblAssTotal.setBounds(10,230,120,30);
		txtAssTotal.setBounds(120,230,100,30);
		
		tableModel = new DefaultTableModel();
		tableModel.addColumn("Unit Name");
		tableModel.addColumn("Assignment Unit");
		tableModel.addColumn("Grade");
		

		// Create the JTable with the table model
		assignmentTable = new JTable(tableModel);
		assignmentTable.getColumnModel().getColumn(0). setPreferredWidth(120);
		assignmentTable.getColumnModel().getColumn(1). setPreferredWidth(15);
		assignmentTable.getColumnModel().getColumn(2). setPreferredWidth(3);
		// Create a JScrollPane to hold the table if needed
		tableScrollPane = new JScrollPane(assignmentTable);
		tableScrollPane.setBounds(400, 30, 380, 400);

		// Add the table to the panel
		add(tableScrollPane);

		txtstdBthNum.setEditable(false);
		txtstdName.setEditable(false);
		txtAssTotal.setEditable(false);
		add(lblstdID);
		add(txtstdID);
		add(lblstdName);
		add(txtstdName);
		add(lblstdBthNum);
		add(txtstdBthNum);
		add(btnShow);
		add(lblAssTotal);
		add(txtAssTotal);
		add(btnClear);
		add(btnSChart);
		add(tableScrollPane);

		btnClear.setBackground(Color.white);
		btnShow.setBackground(Color.white);
		btnSChart.setBackground(Color.white);
		btnShow.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		       showStudentPerformance();
		    }
		});

		btnClear.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
//				clearAssignmentTable();
				txtstdBthNum.setText("");
				txtstdName.setText("");
				txtAssTotal.setText("");
				txtstdID.setText("");
				clearAssignmentTable();
			}
		});
btnSChart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<Student> stdList = new ArrayList<Student>();
				String id =  txtstdID.getText();
				Student std = new Student(id);
				stdList.add(std);
				stdList = new ReadStudentsFromJson().getStudentList();
				if(txtstdID.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Enter Student ID!!!");
				}
				else if(!stdList.contains(std))
				{		JOptionPane.showMessageDialog(null, "Invalid Student ID!!!", "Error",JOptionPane.ERROR_MESSAGE);
 
				}
 
				else {
					new StudentResultInGraph(std);
				}
				stdList.remove(std);
			}
		});
		
	}
		private void updateStudentInfo(Student student) {
		    txtstdName.setText(student.getName());
		    txtstdBthNum.setText(String.valueOf(student.getBatchNo()));
		    
		}
		
		private void clearAssignmentTable() {
		    tableModel.setRowCount(0);
		}
		private void showErrorDialog(String errorMessage) {
		    JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
		}
		private void showStudentPerformance() {
		    try {
		        clearAssignmentTable();

		        ReadStudentsFromJson studentReader = new ReadStudentsFromJson();
		        ReadUnitsFromJson unitReader = new ReadUnitsFromJson();
		        ArrayList<Student> students = studentReader.getStudentList();
		       
		        String studentId = txtstdID.getText();

		        for (Student student : students) {
		            if (student.getId().equals(studentId)) {
		                updateStudentInfo(student);

		                // Calculate the total assignments and display them
		                totalAssignments = student.getAssignmentList().size();
		                txtAssTotal.setText(String.valueOf(totalAssignments));
		                
		                ArrayList<Unit> unitName = unitReader.getUnitList();
		                
		                // Display individual assignments
		                for (Assignment assignment : student.getAssignmentList()) {
		                	Unit un = findUnit(assignment.getUnitNumber(), unitName);
		                    String unitNumber = String.valueOf(assignment.getUnitNumber());
		                    String grade = assignment.getGrade();
		                    String unitlist = un.getUnitName();
		                    
		                    tableModel.addRow(new Object[]{unitlist,unitNumber, grade});
		                }		            
		                return;
		            }
		        }if(txtstdID.getText().isEmpty())
		        	showErrorDialog("Please enter student ID first");
		        else
		        	showErrorDialog("Student ID doesn't exist.");
		    } catch (Exception ex) {
		        new BlankDataExceptions();
		    }
		}

	    private Unit findUnit(int unitNumber, ArrayList<Unit> unitList) {
	        for (Unit unit : unitList) {
	            if (unit.getUnitNumber() == unitNumber) {
	                return unit;
	            }
	        }
	        return null;  // Unit not found
	    }
	    public void refreshFrame() {
	    	if(MainFrame.dark) {
	    		setBackground(Color.black);
	    		lblstdID.setForeground(Color.white);
	    		txtstdID.setForeground(Color.white);
	    		txtstdID.setBackground(Color.black);
	    		lblstdName.setForeground(Color.white);
	    		txtstdName.setBackground(Color.black);
	    		txtstdName.setForeground(Color.white);
	    		lblstdBthNum.setForeground(Color.white);
	    		txtstdBthNum.setBackground(Color.black);
	    		txtstdBthNum.setForeground(Color.white);
	    		lblAssTotal.setForeground(Color.white);
	    		txtAssTotal.setBackground(Color.black);
	    		txtAssTotal.setForeground(Color.white);
	    		btnClear.setBackground(Color.black);
	    		btnClear.setForeground(Color.white);
	    		btnShow.setForeground(Color.white);
	    		btnShow.setBackground(Color.black);
	    		btnSChart.setForeground(Color.white);
	    		btnSChart.setBackground(Color.black);
	    		assignmentTable.setBackground(Color.black);
	    		assignmentTable.setForeground(Color.white);
	    		tableScrollPane.setBackground(Color.black);
	    		tableScrollPane.setForeground(Color.white);
	    	}
	    	else {
	    		setBackground(orignalColor);
	    		lblstdID.setForeground(Color.black);
	    		txtstdID.setForeground(Color.black);
	    		txtstdID.setBackground(Color.white);
	    		lblstdName.setForeground(Color.black);
	    		txtstdName.setBackground(Color.white);
	    		txtstdName.setForeground(Color.black);
	    		lblstdBthNum.setForeground(Color.black);
	    		txtstdBthNum.setBackground(Color.white);
	    		txtstdBthNum.setForeground(Color.black);
	    		lblAssTotal.setForeground(Color.black);
	    		txtAssTotal.setBackground(Color.white);
	    		txtAssTotal.setForeground(Color.black);
	    		btnClear.setBackground(Color.white);
	    		btnClear.setForeground(Color.black);
	    		btnShow.setForeground(Color.black);
	    		btnShow.setBackground(Color.white);
	    		btnSChart.setForeground(Color.black);
	    		btnSChart.setBackground(Color.white);
	    		assignmentTable.setBackground(Color.white);
	    		assignmentTable.setForeground(Color.black);
	    		tableScrollPane.setBackground(Color.white);
	    		tableScrollPane.setForeground(Color.black);
	    	}
	    }
		


		}
//private void displayAssignments(ArrayList<Assignment> assignments) {
//    for (Assignment assignment : assignments) {
//        String unitNumber = String.valueOf(assignment.getUnitNumber());
//        String grade = assignment.getGrade();
//       
//        tableModel.addRow(new Object[]{unitNumber, grade});
//       
//    }
//}
    
