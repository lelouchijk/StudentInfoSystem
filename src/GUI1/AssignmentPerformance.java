package GUI1;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class AssignmentPerformance  extends JPanel{
	
	private Color originalColor; 
	private JLabel lblBthNum = new JLabel("Batch Number");
	private JTextField txtBthNum = new JTextField();
	
	private JLabel lblUnitNum = new JLabel("Unit Number");
	private JTextField txtUnitNum = new JTextField();
	
	private JButton btnShow = new JButton("Show");
	private JButton btnClear = new JButton("Clear");

	private Font font1=new Font("Times New Roman", Font.PLAIN+Font.BOLD, 10);

	private JTable assignmentTable;
	private DefaultTableModel tableModel;

	private ArrayList<Student> studentList;
	private ReadStudentsFromJson studentReader = new ReadStudentsFromJson();
	
	public AssignmentPerformance() {

		setLayout(null);
		setBorder(new TitledBorder("Show assignment information"));
		originalColor = this.getBackground();
		
		lblBthNum.setBounds(10,30,100,30);
		add(lblBthNum);
		txtBthNum.setBounds(120,30,200,30);
        add(txtBthNum);

        lblUnitNum.setBounds(10,80,100,30);
        add(lblUnitNum);

        txtUnitNum.setBounds(120, 80, 200, 30);
        add(txtUnitNum);

        btnShow.setBounds(10,130,100,30);
        add(btnShow);
        btnClear.setBounds(120,130,100,30);
        add(btnClear);
		 
        tableModel = new DefaultTableModel();
        tableModel.addColumn("ID");
        tableModel.addColumn("Grade");
        
        
        assignmentTable = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(assignmentTable);
        tableScrollPane.setBounds(400, 30, 380, 400);
        btnClear.setBackground(Color.white);
        btnShow.setBackground(Color.white);
        add(tableScrollPane);
        
		
        btnShow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int unitNumber = parseInt(txtUnitNum.getText());
                    int batchNumber = parseInt(txtBthNum.getText());
                    showData(unitNumber, batchNumber);
                } catch (NumberFormatException ex) {
                    showErrorDialog("Invalid input for Unit Number or Batch Number.");
                }
            }
        });
        btnClear.addActionListener(new ActionListener() {

        	@Override
        	public void actionPerformed(ActionEvent e) {
        		//clearAssignmentTable();
        		txtBthNum.setText("");
        		txtUnitNum.setText("");


        	}
        });
	}
	public void showData(int unitNumber, int batchNumber) {
		clearAssignmentTable();
	    studentList = studentReader.getStudentList();
	    ArrayList<Student> stdList = new ArrayList<Student>();
	    boolean isDataFound = false; 
	    try {
	        for (Student std : studentList) {
	            if (batchNumber == std.getBatchNo()) {
	                boolean isFound = false;
	                //setTxtName(std.getName());
	                ArrayList<Assignment> assList = std.getAssignmentList();
	                for (Assignment ass : assList) {
	                    if (unitNumber == ass.getUnitNumber()) {
	                        String stdID = std.getId();
	                        String grade = ass.getGrade();
	                        //String[] res = { stdID, grade };
	                        tableModel.addRow(new Object[] {stdID,grade});
	                        isFound = true;
	                        isDataFound = true; // Data was found
	                        break;
	                    }
	                }
	                if (isFound) {
	                    stdList.add(std);
	                }
	            }
	        }

	        if (!isDataFound) {
	            
	            showErrorDialog("Invalid Batch Number or Unit Number.");
	        }
	    } catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(null, "Invalid input for Unit Number or Batch Number.", "Error", JOptionPane.ERROR_MESSAGE);
	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(null, "An error occurred while processing data.", "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}


	private void showErrorDialog(String errorMessage) {
	    JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
	}

	private int parseInt(String text) {
	    try {
	        return Integer.parseInt(text);
	    } catch (NumberFormatException ex) {
	        throw new NumberFormatException("Invalid input: " + text);
	    }
	}
		
	private void clearAssignmentTable() {
	    tableModel.setRowCount(0);
	}
	public void refreshFrame() {
		if(MainFrame.dark) {
			setBackground(Color.black);
			lblBthNum.setForeground(Color.white);
			txtBthNum.setBackground(Color.black);
			txtBthNum.setForeground(Color.white);
			lblUnitNum.setForeground(Color.white);
			txtUnitNum.setBackground(Color.black);
			txtUnitNum.setForeground(Color.white);
			btnShow.setBackground(Color.black);
			btnShow.setForeground(Color.white);
			btnClear.setBackground(Color.black);
			btnClear.setForeground(Color.white);
			assignmentTable.setBackground(Color.BLACK);
			assignmentTable.setForeground(Color.white);
		}
		else {
			setBackground(originalColor);
			lblBthNum.setForeground(Color.black);
			txtBthNum.setBackground(Color.white);
			txtBthNum.setForeground(Color.black);
			lblUnitNum.setForeground(Color.black);
			txtUnitNum.setBackground(Color.white);
			txtUnitNum.setForeground(Color.black);
			btnShow.setBackground(Color.white);
			btnShow.setForeground(Color.black);
			btnClear.setBackground(Color.white);
			btnClear.setForeground(Color.black);
			assignmentTable.setBackground(Color.white);
			assignmentTable.setForeground(Color.black);
		}
	}
	

	
	public static void main(String[] args) {
        JFrame frame = new JFrame("Assignment Information");
        AssignmentPerformance panel = new AssignmentPerformance();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500);
        frame.add(panel);
        frame.setVisible(true);
    }
	
}

