package GUI1;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class BatchInfo extends JPanel{
	private JLabel lblBatchInfo = new JLabel("Batch Info");
	private JPanel selectPanel = new JPanel();
	private Color originalColor;
	private String[] batchNo = {"1","2","3","4","5"};
	private JComboBox cBthNum = new JComboBox(batchNo);
	private JLabel lblBthNum = new JLabel("Batch Number");
	private String[] year = {"1","2"};
	private JComboBox cYear = new JComboBox(year);
	private JLabel lblYear = new JLabel("Year");
	private String[] semester = {"1","2"};
	private JComboBox cSeme = new JComboBox(semester);
	private JLabel lblSeme = new JLabel("Semester");
	
	private JLabel lblCurYear = new JLabel("Current Year");
	private static JTextField txtCurYear = new JTextField(10);
	
	private JLabel lblCurSem = new JLabel("Current Semester");
	private static JTextField txtCurSem = new JTextField(10);
	
	private JButton btnClear = new JButton("Clear");
	private JButton btnShow = new JButton("Show");
    
    private JTable batchInfoTable;
    private static DefaultTableModel tableModel;

    public BatchInfo() {
        
        setLayout(null);
        setBorder(new TitledBorder(" Show Batch Information"));
        originalColor = this.getBackground();
        
        lblBthNum.setBounds(10,30,100,30);
        cBthNum.setBounds(120,30,200,30);      
    
        lblYear.setBounds(10,80,100,30);
        cYear.setBounds(120, 80, 200, 30);

        lblSeme.setBounds(10,130,100,30);
        cSeme.setBounds(120,130,200,30);

        btnShow.setBounds(10,180,100,30);
        
        lblCurYear.setBounds(10,180,100,30);
        txtCurYear.setBounds(120,280 ,200 ,30 );
        
        lblCurSem.setBounds(10,280,140,30);
        txtCurSem.setBounds(120,280,200,30);
        
        txtCurYear.setEditable(false);
		txtCurSem.setEditable(false);
       
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Name");
        tableModel.addColumn("ID");
      	tableModel.addColumn("Unit Number");
        tableModel.addColumn("Grade");

       // Create the JTable with the table model
       batchInfoTable = new JTable(tableModel);

       add(btnClear);
       btnClear.setBounds(120,180,100,30);
       batchInfoTable.getColumnModel().getColumn(0). setPreferredWidth(80);
       batchInfoTable.getColumnModel().getColumn(1). setPreferredWidth(40);
       batchInfoTable.getColumnModel().getColumn(2). setPreferredWidth(30);
       batchInfoTable.getColumnModel().getColumn(3). setPreferredWidth(5);
       JScrollPane tableScrollPane = new JScrollPane(batchInfoTable);
       tableScrollPane.setBounds(400, 30, 380, 400);
       add(tableScrollPane);
        
        add(cBthNum);
        add(lblBthNum);
        add(lblYear);
        add(cYear);
        add(lblSeme);
        add(cSeme);
        add(btnShow);
        btnClear.setBackground(Color.white);
        btnShow.setBackground(Color.white);
        
        btnShow.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				String batch=cBthNum.getSelectedItem().toString();
				int batchno=Integer.parseInt(batch);
				String yr=cYear.getSelectedItem().toString();
	            int yearno = Integer.parseInt(yr);
	            String se = cSeme.getSelectedItem().toString();
	            int semno=Integer.parseInt(se);
	            //updateBathInfo(yr,se);
	            displayBatch( batchno, yearno, semno);
			}
		});
        btnClear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				clearAssignmentTable();
				
			}
		});
    }
	public void displayBatch(int batchno,int yearno,int semno) {
		ArrayList<Batch> batchList= new ReadBatchesFromJson().getBatchList();
		ArrayList<Student> studentList = new ReadStudentsFromJson().getStudentList();
		ArrayList<Semester> semesterList = new ReadSemestersFromJson().getSemesterList();
		ArrayList<Unit> unitList = new ReadUnitsFromJson().getUnitList();
		clearAssignmentTable();
		try {
		for(Student a : studentList) { 
			ArrayList<Assignment>assignlist=a.getAssignmentList();
			if(a.getBatchNo()==batchno) {
				
				if(yearno==1 && semno==1) {
					for(int i=0;i<4;i++) {
						int z = assignlist.get(i).getUnitNumber();
						String g = assignlist.get(i).getGrade();
						String[] all = {a.getName(),a.getId(),Integer.toString(z),g};
						tableModel.addRow(all);
						}
				}
				else if(yearno==1 && semno==2) {
						for(int i=4;i<8;i++) {
							int z = assignlist.get(i).getUnitNumber();
							String g = assignlist.get(i).getGrade();
							String[] all = {a.getName(),a.getId(),Integer.toString(z),g};
							tableModel.addRow(all);
							}
					}
				else if(yearno==2 && semno==1) {
					for(int i=8;i<12;i++) {
						int z = assignlist.get(i).getUnitNumber();
						String g = assignlist.get(i).getGrade();
						String[] all = {a.getName(),a.getId(),Integer.toString(z),g};
						tableModel.addRow(all);
						}
				}
				else if(yearno==2 && semno==2) {
					for(int i=12;i<15;i++) {
						int z = assignlist.get(i).getUnitNumber();
						String g = assignlist.get(i).getGrade();
						String[] all = {a.getName(),a.getId(),Integer.toString(z),g};
						tableModel.addRow(all);
						}
				}
			}
			
		}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "The Batch,you selected is not found!! ", "Promt Message", JOptionPane.ERROR_MESSAGE);
		}
		}

        private static void clearAssignmentTable() {
		    tableModel.setRowCount(0);
        }
        public void refreshFrame()
        {
        	//System.out.println("MainFrame Dark : "+MainFrame.dark);
            if (MainFrame.dark) 
            {
            	btnShow.setBackground(Color.BLACK.darker());
        		btnShow.setForeground(Color.white);
        		btnClear.setBackground(Color.BLACK.darker());
        		btnClear.setForeground(Color.white);
        		lblBatchInfo.setForeground(Color.white);
        		lblBthNum.setForeground(Color.white);
        		lblSeme.setForeground(Color.white);
        		lblYear.setForeground(Color.white);
        		cBthNum.setBackground(Color.black.brighter());
        		cBthNum.setForeground(Color.white);
        		cSeme.setBackground(Color.black);
        		cSeme.setForeground(Color.white);
        		cYear.setBackground(Color.black);
        		cYear.setForeground(Color.white);
        		batchInfoTable.setBackground(Color.black);
        		batchInfoTable.setForeground(Color.white);
            	setBackground(Color.black.brighter());
            }
            else {
            	btnShow.setBackground(Color.white);
        		btnShow.setForeground(Color.black);
        		btnClear.setBackground(Color.white);
        		btnClear.setForeground(Color.black);
        		//lblAssInfo.setForeground(Color.white);
        		lblBatchInfo.setForeground(Color.black);
        		lblBthNum.setForeground(Color.black);
        		lblSeme.setForeground(Color.black);
        		lblYear.setForeground(Color.black);
        		cBthNum.setBackground(Color.white.brighter());
        		cBthNum.setForeground(Color.black);
        		cSeme.setBackground(Color.white);
        		cSeme.setForeground(Color.black);
        		cYear.setBackground(Color.white);
        		cYear.setForeground(Color.black);
        		batchInfoTable.setBackground(Color.white);
        		batchInfoTable.setForeground(Color.black);
            	setBackground(originalColor);
            }
        }

}

