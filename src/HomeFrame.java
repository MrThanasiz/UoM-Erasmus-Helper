import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;



public class HomeFrame extends JFrame
{

	//Frame Options 
	private static final int WIDTH = 1280;
	private static final int HEIGHT = 720;
	//login button options
	private static final int LOGIN_PANEL_WIDTH = WIDTH*4/20;
	private static final int LOGIN_PANEL_HEIGHT = HEIGHT*1/10;
	//register button options
	private static final int REGISTER_PANEL_WIDTH = WIDTH*4/20;
	private static final int REGISTER_PANEL_HEIGHT = HEIGHT*1/10;
	//info button options
	private static final int INFO_PANEL_WIDTH = WIDTH*5/20;
	private static final int INFO_BUTTON_PANEL_WIDTH = INFO_PANEL_WIDTH;
	private static final int INFO_PANEL_HEIGHT = HEIGHT*1/10;
	private static final int INFO_BUTTON_PANEL_HEIGHT = INFO_PANEL_HEIGHT;
	//username text field options 
	private static final int USERNAME_PANEL_WIDTH = WIDTH * 2/15;
	private static final int USERNAME_TEXT_AREA_WIDTH = USERNAME_PANEL_WIDTH;
	private static final int USERNAME_PANEL_HEIGHT = HEIGHT * 1/25;
	private static final int USERNAME_TEXT_AREA_HEIGHT = USERNAME_PANEL_HEIGHT;
	//password text field options 
	private static final int PASSWORD_PANEL_WIDTH = WIDTH * 2/15;
	private static final int PASSWORD_TEXT_AREA_WIDTH = PASSWORD_PANEL_WIDTH;
	private static final int PASSWORD_PANEL_HEIGHT = HEIGHT * 1/25;
	private static final int PASSWORD_TEXT_AREA_HEIGHT = PASSWORD_PANEL_HEIGHT;
	//messages options
	private static final int MESSAGE_PANEL_HEIGHT = 15;
	private static final int MESSAGE_PANEL_WIDTH = 25;
	//Secretariat Login Details
	private static final String  SECRUSERNAME = "SecrUser";
	private static final String  SECRPASSWORD = "SecrPass";
	
	

	
	private JPanel panel;
	private static JPanel panelStatic;
	private JPanel LoginButtonPanel;
	private JPanel RegisterButtonPanel;
	private JPanel InfoButtonPanel;
	private JPanel UsernameFieldPanel;
	private JPanel PasswordFieldPanel;
	private JPanel PasswordLabelAbovePanel;
	private JPanel UsernameLabelAbovePanel;
	
	
	
	private static JButton loginButton;
	private static JButton registerButton;
	private static JButton infoButton;
	
	private static JTextArea username;
	private static JTextArea password;
	
	public HomeFrame() {
		this.setPanel();
		
		this.setContentPane(panel);
		
		this.setVisible(true);
		//Set the frame size
		this.setSize(WIDTH, HEIGHT);
		//Set the start position
		this.setLocationRelativeTo(null);
		
		this.setTitle("Welcome to UoM Erasmus Helper!");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	private void setPanel() {
		//create a panel
		panel = new JPanel();
		//used box layout

		
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		//call-create elements
		this.usernameLablelAbove();
		this.setUsernameTextPanel();
		this.passwordLabelAbove();
		this.setPasswordTextPanel();
		this.setLoginButtonPanel();
		this.setRegisterButtonPanel();
		this.setInfoButtonPanel();
		
		//add elements to panel
		panel.add(UsernameLabelAbovePanel);
		panel.add(UsernameFieldPanel);
		panel.add(PasswordLabelAbovePanel);
		panel.add(PasswordFieldPanel);
		panel.add(LoginButtonPanel);
		panel.add(RegisterButtonPanel);
		panel.add(InfoButtonPanel);
		
		//button is pressed
		loginButton.addActionListener(new Action());
		registerButton.addActionListener(new Action());
		infoButton.addActionListener(new Action());

	
	}
	
	public void setLoginButtonPanel() {
		
		LoginButtonPanel = new JPanel();
		LoginButtonPanel.setPreferredSize(new Dimension(LOGIN_PANEL_WIDTH, LOGIN_PANEL_HEIGHT));
		
		loginButton = new JButton("Login");
				
		LoginButtonPanel.add(loginButton);
	}
	
	public void setRegisterButtonPanel() {
		
		RegisterButtonPanel = new JPanel();
		RegisterButtonPanel.setPreferredSize(new Dimension(REGISTER_PANEL_WIDTH, REGISTER_PANEL_HEIGHT));
	
		registerButton = new JButton("Register");
				
		RegisterButtonPanel.add(registerButton);		
	}
	public void setInfoButtonPanel() {
		
		InfoButtonPanel = new JPanel();
		InfoButtonPanel.setPreferredSize(new Dimension(INFO_PANEL_WIDTH, INFO_PANEL_HEIGHT));
		
		infoButton = new JButton("What is Erasmus?");
		infoButton.setBounds(250,250,INFO_BUTTON_PANEL_WIDTH,INFO_BUTTON_PANEL_HEIGHT);
		
		InfoButtonPanel.add(infoButton);
				
		
	}
	
	public void setUsernameTextPanel() {
		
		UsernameFieldPanel = new JPanel();
		UsernameFieldPanel.setPreferredSize(new Dimension(USERNAME_PANEL_WIDTH , USERNAME_PANEL_HEIGHT));
		
		username = new JTextArea();
		username.setPreferredSize(new Dimension(USERNAME_TEXT_AREA_WIDTH, USERNAME_TEXT_AREA_HEIGHT));
		
		UsernameFieldPanel.add(username);
	
	}
	
	
	public void setPasswordTextPanel() {
		
		PasswordFieldPanel = new JPanel();
		PasswordFieldPanel.setPreferredSize(new Dimension(PASSWORD_PANEL_WIDTH , PASSWORD_PANEL_HEIGHT));
		
		
		password = new JTextArea();
		
		password.setPreferredSize(new Dimension(PASSWORD_TEXT_AREA_WIDTH, PASSWORD_TEXT_AREA_HEIGHT));
		
	
		PasswordFieldPanel.add(password);
		
		
	}
	
	public void usernameLablelAbove() {
		UsernameLabelAbovePanel = new JPanel();
		UsernameLabelAbovePanel.setPreferredSize(new Dimension(MESSAGE_PANEL_WIDTH , MESSAGE_PANEL_HEIGHT));
		
		JLabel labela = new JLabel("Enter a username :");
		
		UsernameLabelAbovePanel.add(labela);
		
	}
	
	public void passwordLabelAbove() {
		PasswordLabelAbovePanel = new JPanel();
		PasswordLabelAbovePanel.setPreferredSize(new Dimension(MESSAGE_PANEL_WIDTH , MESSAGE_PANEL_HEIGHT));
		
		JLabel labela = new JLabel("Enter your password :");
		
		PasswordLabelAbovePanel.add(labela);
		
	}
	
	
	public static void warningMessage() {
		JOptionPane.showMessageDialog(panelStatic,
			    "Wrong Username (and) or Password.",
			    "Error",
			    JOptionPane.WARNING_MESSAGE);
	}

	public static JButton getLoginButton() {
		return loginButton;
	}
	
	public static JButton getRegisterButton() {
		return registerButton;
	}
	
	public static JButton getInfoButton() {
		return infoButton;
	}
	
	public static String getUsername() {
		return username.getText();
	 
	}
	
	public static String getPasswordHF() {
		return password.getText();
	}
	


	class Action implements ActionListener {
	 
	 String username = null;
	 String password = null;
	 String id = null;	
	
	 
	public void actionPerformed(ActionEvent e) {
		
	
	
			if (e.getSource() == HomeFrame.getLoginButton()) {
				//System.out.println("Button login Working");
				 
				 username = HomeFrame.getUsername();
				 password = HomeFrame.getPasswordHF();
				
				CentralRegistry.desirializeUsers();
				
				if (username.equals(SECRUSERNAME) && password.equals(SECRPASSWORD)) {
					dispose();
					new SecretariatFrame();
				}
				
				Student stud = LogRegCheck.checkUsername(username);
				
				//System.out.println(stud);
				
				//System.out.println(CentralRegistry.getStudents());
				
				
				
				if(stud == null) {
					if (!(username.equals(SECRUSERNAME) && password.equals(SECRPASSWORD)))
						 HomeFrame.warningMessage();
				}
				 else
				 {
					 if (LogRegCheck.checkPassword(stud , password))  {
						 //close window
						 dispose();
						 //set next window visible
						 //stud.setDepartment(CentralRegistry.getDepartments().get(0));
						 new MainFrame(stud);
					 
					 }
					 else
						 HomeFrame.warningMessage();
				 }
			}
			else if (e.getSource() == HomeFrame.getRegisterButton()) {
				//close window
				dispose();
				//set next window visible
				
				new RegisterFrame();
				
			}
			else if (e.getSource() == HomeFrame.getInfoButton()) {
				
				try {
				    Desktop.getDesktop().browse(new URL("https://www.uom.gr/erasmus-office#undefined1").toURI());
				} catch (Exception e1) {}
			
			}
		}
	}
}
