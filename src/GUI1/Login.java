package GUI1;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Login extends JFrame {
	final int FRM_WIDTH = 350, FRM_HEIGHT = 230;
	Toolkit tk = getToolkit();
	int SCR_WIDTH = (int) (tk.getScreenSize().getWidth());
	int SCR_HEIGHT = (int) (tk.getScreenSize().getHeight());
	int frmX = SCR_WIDTH/2 - FRM_WIDTH/2;
	int frmY = SCR_HEIGHT/2 - FRM_HEIGHT/2;

	private JLabel lblName = new JLabel("Name");
	private JTextField txtName = new JTextField(20);
	private JLabel lblPw = new JLabel("Password");
	private JPasswordField txtPw = new JPasswordField();

	private final char defaultChar = txtPw.getEchoChar();
	private JCheckBox showPwBtn = new  JCheckBox();
	private JRadioButton rdoAdm = new JRadioButton("Admin");
	private JRadioButton rdoUser= new JRadioButton("User");

	private JButton btnLogIn = new JButton("Log In");
	private JButton btnClr = new JButton("Clear");
	private ButtonGroup btnGp = new ButtonGroup();

	private JPanel panel = new JPanel();
	private ImageIcon imgIcon = new ImageIcon("showPw.png");
	private ImageIcon imgIcon2 = new ImageIcon("showPw2.png");
	public Login() {
		setVisible(true);
		setTitle("ITPro");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocation(frmX,frmY);
		setSize(FRM_WIDTH,FRM_HEIGHT);


		//setLocationRelativeTo(null); setlocation not calculated way
		setLayout(null);
		lblName.setBounds(15, 10, 70, 30);
		add(lblName);

		txtName.setBounds(80, 15, 200, 25);
		add(txtName);


		lblPw.setBounds(10,55,70,30);
		add(lblPw);

		txtPw.setBounds(80, 60, 200, 25);
		//txtPw.setBackground(Color.white);
		add(txtPw);

		showPwBtn.setIcon(imgIcon);
		showPwBtn.setSelectedIcon(imgIcon2);
		showPwBtn.setBounds(280, 58, 30, 30); //280, 58, 30, 30
		add(showPwBtn);

		btnGp.add(rdoAdm);
		btnGp.add(rdoUser);
		panel.add(rdoAdm);
		panel.add(rdoUser);

		panel.setBounds(80,100,180,50);
		add(panel);

		btnLogIn.setBounds(80, 150, 80, 25);
		btnLogIn.setBackground(Color.white);

		btnClr.setBounds(170, 150, 70, 25);
		btnClr.setBackground(Color.white);
		add(btnLogIn);
		add(btnClr);

		showPwBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(showPwBtn.isSelected()) 
					txtPw.setEchoChar((char)0) ;
				else 
					txtPw.setEchoChar(defaultChar);

			}
		});

		btnLogIn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					if(txtName.getText().isEmpty() || txtPw.getText().isEmpty() || !(rdoAdm.isSelected() || rdoUser.isSelected()))
						throw new BlankDataExceptions();
					if(rdoAdm.isSelected()) {
						if(txtName.getText().equalsIgnoreCase("@dmin")&&txtPw.getText().equalsIgnoreCase("@dmin123")) {
							//new IAmHuman();
							JOptionPane.showMessageDialog(null, "Log in as Admin!", "Promt Message", JOptionPane.PLAIN_MESSAGE);
							new MainFrame("Admin");
							dispose();
						}else {
							JOptionPane.showMessageDialog(null, "Invalid user name or password", "Log in error", JOptionPane.ERROR_MESSAGE);

						}
					}else {
						if(txtName.getText().equalsIgnoreCase("User")&&txtPw.getText().equalsIgnoreCase("user123")) {
							JOptionPane.showMessageDialog(null, "Logging in as User", "Promt Message", JOptionPane.PLAIN_MESSAGE);
							new MainFrame("User");
							dispose();
						}else {
							JOptionPane.showMessageDialog(null, "Invalid user name or password", "Log in error", JOptionPane.ERROR_MESSAGE);

							txtName.requestFocus();							
						}

					}
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
					txtName.requestFocus();
				}
			}
		});
		btnClr.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				txtName.setName("");
				txtPw.setName("");
				txtName.requestFocus(true);
			}
		});
	}
	public static void main (String[] args) {
		new Login();
	}

}



