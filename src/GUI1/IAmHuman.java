package GUI1;

import java.awt.Checkbox;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

public class IAmHuman extends JFrame{
	final int FRM_WIDTH = 280, FRM_HEIGHT = 100;
	Toolkit tk = getToolkit();
	int SCR_WIDTH = (int) (tk.getScreenSize().getWidth());
	int SCR_HEIGHT = (int) (tk.getScreenSize().getHeight());
	int frmX = SCR_WIDTH/2 - FRM_WIDTH/2;
	int frmY = SCR_HEIGHT/2 - FRM_HEIGHT/2;
	
	ImageIcon imgIcon1;
	ImageIcon imgIcon2;
	JCheckBox chkbox = new JCheckBox();
	
	public IAmHuman() {
		imgIcon1 = new ImageIcon("right.jpg");
		imgIcon2 = new ImageIcon("wrong.jpg");
		chkbox.setText("Confirm ");
		chkbox.setIcon(imgIcon1);
		chkbox.setSelectedIcon(imgIcon2);
		add(chkbox);
		setBackground(Color.white);
		setVisible(true);
		setSize(FRM_WIDTH,FRM_HEIGHT);
		setLocation(frmX, frmY);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(new FlowLayout(FlowLayout.CENTER));
		
		chkbox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new ConfirmIAmHuman();
				dispose();
			}
		});
	}
	public static void main(String[]args) {
		new IAmHuman();
		
	}
}
