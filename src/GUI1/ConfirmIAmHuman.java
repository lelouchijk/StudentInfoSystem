package GUI1;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ConfirmIAmHuman extends JFrame  {
	final int FRM_WIDTH = 320, FRM_HEIGHT = 400;
	Toolkit tk = getToolkit();
	int SCR_WIDTH = (int) (tk.getScreenSize().getWidth());
	int SCR_HEIGHT = (int) (tk.getScreenSize().getHeight());
	int frmX = SCR_WIDTH/2 - FRM_WIDTH/2;
	int frmY = SCR_HEIGHT/2 - FRM_HEIGHT/2;
	
	private ImageIcon img1 = new ImageIcon("amie1.jpg");
	private ImageIcon img2 = new ImageIcon("eiphyo1.png");
	private ImageIcon img3 = new ImageIcon("tsl1.png");

	
	private ImageIcon img4 = new ImageIcon("amie2.png");
	private ImageIcon img5 = new ImageIcon("eiphyo2.png");
	private ImageIcon img6 = new ImageIcon("tsl2.jpg");

	private JLabel lblName = new JLabel("Select Thant Sin");
	private JCheckBox btn1 = new JCheckBox();
	private JCheckBox btn2 = new JCheckBox();
	private JCheckBox btn3 = new JCheckBox();
	private JCheckBox btn4 = new JCheckBox();
	private JCheckBox btn5 = new JCheckBox();		// C A T H A E R I N
	private JCheckBox btn6 = new JCheckBox();
	private JCheckBox btn7 = new JCheckBox();
	private JCheckBox btn8 = new JCheckBox();
	private JCheckBox btn9 = new JCheckBox();
	
	private JPanel panel1 = new JPanel();
	private JButton nextBtn = new JButton("Next");
	
	private GridLayout frmLayout = new GridLayout(3,3,1,1);
	
	public ConfirmIAmHuman() {
		setVisible(true); setSize(FRM_WIDTH, FRM_HEIGHT); setLocation(frmX, frmY); setDefaultCloseOperation(EXIT_ON_CLOSE); setResizable(false); setTitle(""); setLayout(null); panel1.setBounds(0, 0, 300, 300); panel1.setLayout(frmLayout); add(panel1); 
		btn1.setIcon(img1); btn2.setIcon(img2); btn3.setIcon(img1); btn4.setIcon(img3); btn5.setIcon(img3); btn6.setIcon(img1); btn7.setIcon(img2); btn8.setIcon(img2); btn9.setIcon(img3);
		btn1.setSelectedIcon(img4); btn2.setSelectedIcon(img5); btn3.setSelectedIcon(img4); btn4.setSelectedIcon(img6); btn5.setSelectedIcon(img6); btn6.setSelectedIcon(img4); btn7.setSelectedIcon(img5); btn8.setSelectedIcon(img5); btn9.setSelectedIcon(img6);
		panel1.add(btn1); panel1.add(btn2); panel1.add(btn3); panel1.add(btn4); panel1.add(btn5); panel1.add(btn6); panel1.add(btn7); panel1.add(btn8); panel1.add(btn9); 
		add(panel1);
		lblName.setBounds(20, 295, 200, 80);
		add(lblName);
		nextBtn.setBounds(220, 320, 70, 30);
		nextBtn.setBackground(Color.green);
		//nextBtn.setForeground(Color.white);
		add(nextBtn);
		nextBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(btn4.isSelected() && btn5.isSelected() && btn9.isSelected())
					dispose();
				else {
					JOptionPane.showMessageDialog(null, "Choose Again", "Error Message", JOptionPane.ERROR_MESSAGE);
					
				}
				}
		});
		
	}
	public static void main(String[]args) {
		new ConfirmIAmHuman();
	}


}
