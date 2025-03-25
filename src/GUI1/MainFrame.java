package GUI1;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class MainFrame extends JFrame{
	//private JLabel lblTitle1 = new JLabel("Student Performance Analysis");
	private Font fontObj = new Font("Times New Roman",Font.PLAIN+Font.BOLD,30);
	private Font fontHeader = new Font("Times New Roman",Font.BOLD+Font.ITALIC,30);
	private Color originalColor; 
	
	
	final int FRM_WIDTH = 800, FRM_HEIGHT = 500;
	Toolkit tk = getToolkit();
	int SCR_WIDTH = (int) (tk.getScreenSize().getWidth());
	int SCR_HEIGHT = (int) (tk.getScreenSize().getHeight());
	int frmX = SCR_WIDTH/2 - FRM_WIDTH/2;
	int frmY = SCR_HEIGHT/2 - FRM_HEIGHT/2;
	
	private StudentPerformance stuP = new StudentPerformance();
	private BatchInfo batchI = new BatchInfo();
	private AssignmentPerformance assP = new AssignmentPerformance();
	
	private JMenuBar menuBar=new JMenuBar();
	private JMenu fileMenu=new JMenu("Menu");
	private JMenuItem assignmentItem=new JMenuItem("Assignment Information");
	private JMenuItem batchItem=new JMenuItem("Batch Information");
	private JMenuItem performanceItem=new JMenuItem("Student Performance");
	private JMenuItem exitMenuItem=new JMenuItem("Log Out");
	
	public static boolean dark = false;
	private JLabel lblLogoName = new JLabel("IT Pro");
	private JLabel ImgLabel = new JLabel(new ImageIcon("javaFrame.jpg"));
	private JPanel currentPanel;
	private JPanel panel1 = new JPanel();
	private JPanel panelTop = new JPanel();
	private JToggleButton toggle = new JToggleButton();
	FlowLayout frmLayout = new FlowLayout(FlowLayout.RIGHT);
	public MainFrame(String userType) {
		setVisible(true);
		setLocation(frmX, frmY);
		setSize(FRM_WIDTH, FRM_HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle(userType+"Mode");
		setJMenuBar(menuBar);
		setLayout(null);
		
		if(userType.equals("User")) {
				batchItem.setEnabled(false);
				assignmentItem.setEnabled(false);
		}
		menuBar.add(fileMenu);
		fileMenu.add(assignmentItem);
		fileMenu.add(batchItem);
		fileMenu.add(performanceItem);
		fileMenu.addSeparator();
		fileMenu.add(exitMenuItem);

		panelTop.setBounds(0,0,800,50);
		panelTop.setLayout(null);
		originalColor = panel1.getBackground();
		toggle.setBounds(750, 10, 30, 30);
		toggle.setBackground(Color.white);
		panelTop.add(toggle);
		lblLogoName.setBounds(350, 0, 100, 50);
		lblLogoName.setFont(fontHeader);
		panelTop.add(lblLogoName);
		add(panelTop);

		panel1.setLayout(null);
		panel1.setBounds(0, 50, 800, 450);
		ImgLabel.setBounds(0, 0, 800, 450);
		panel1.add(ImgLabel);		
		add(panel1);
		currentPanel=panel1;
		
		exitMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Login();
			}
		});
		assignmentItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				remove(currentPanel);
				repaint();// parent of validate 
//				revalidate();	//refresh the frame without delay 

				currentPanel=assP;
				currentPanel.setBounds(0, 50, 800, 450);
				add(currentPanel);
			}
		});
		batchItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				remove(currentPanel);
				repaint();
				currentPanel = batchI;
				currentPanel.setBounds(0, 50, 800, 450);
				add(currentPanel);
			}
		});
		
		performanceItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				remove(currentPanel);
				repaint();
				currentPanel = stuP;
				currentPanel.setBounds(0, 50, 800, 450); //786,486
				add(currentPanel);
			}
		});
		
		toggle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(dark) {
					dark = false;
				
				}
				else {
					dark = true;
				
				}
				refreshFrame();
				batchI.refreshFrame();
				assP.refreshFrame();
				stuP.refreshFrame();
				return;
			}
		});
		
	}
	public void refreshFrame() {
		if(dark) {
			panelTop.setBackground(Color.black);
			//setBackground(Color.black);
			panel1.setBackground(Color.black);
			lblLogoName.setForeground(Color.white);
		}
		else {
			panelTop.setBackground(originalColor);
			//setBackground(Color.white);
			//panel1.setBackground(Color.white);
			//panel1.setBackground(originalColor);
			lblLogoName.setForeground(Color.black);
			
		}
	}
	public static void main (String[] args) {
		new MainFrame("admin");
	}

}
//chkBox = new JCheckBox();
//chkBox.setText("asdfasfd");
//chkBox.setFocusable(false);
//imgIconDay = new ImageIcon("day.png");
//imgIconNight= new ImageIcon("night.png");
//chkBox.setIcon(imgIconDay);
//chkBox.setSelectedIcon(imgIconNight);
//panel1.setLayout(frmLayout);
//pack();
//panel1.setBounds(700, 0, 50, 50);
////chkBox.setBounds(700, 0, 50, 50);
//panel1.add(chkBox);
//add(panel1);