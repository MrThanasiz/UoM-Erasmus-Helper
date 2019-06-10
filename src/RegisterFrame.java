import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;



public class RegisterFrame extends JFrame implements ActionListener
{
	//Frame Options 
		private static final int WIDTH = 1280;
		private static final int HEIGHT = 720;
		//register button options
		private static final int REGISTER_PANEL_WIDTH = WIDTH*4/20;
		private static final int REGISTER_PANEL_HEIGHT = HEIGHT*1/10;
		//password text field options 
		private static final int PASSWORD_PANEL_WIDTH = WIDTH * 1/10;
		private static final int PASSWORD_TEXT_AREA_WIDTH = PASSWORD_PANEL_WIDTH;
		private static final int PASSWORD_PANEL_HEIGHT = HEIGHT * 1/40;
		private static final int PASSWORD_TEXT_AREA_HEIGHT = PASSWORD_PANEL_HEIGHT;
		//messages options
		private static final int MESSAGE_PANEL_HEIGHT = 15;
		private static final int MESSAGE_PANEL_WIDTH = 25;
		//combo box options
		private static final int CB_PANEL_HEIGHT = 15;
		private static final int CB_PANEL_WIDTH = 25;
		//id text field options 
		private static final int ID_PANEL_HEIGHT = HEIGHT * 1/45;
		private static final int ID_TEXT_AREA_HEIGHT = ID_PANEL_HEIGHT;
		private static final int ID_PANEL_WIDTH = WIDTH * 1/25;
		private static final int ID_TEXT_AREA_WIDTH = ID_PANEL_WIDTH;
		
		private JPanel panel;
		private JPanel RegisterButtonPanel;
		private JPanel PasswordFieldPanel;
		private JPanel IDFieldPanel;
		private JPanel PasswordLabelAbovePanel;
		private JPanel PasswordLabelBelowPanel;
		private JPanel DepLabelAbove;
		private JPanel DepLabelAbovePanel;
		private JPanel IDLabelAbove;
		private JPanel IDLabelAbovePanel;
		private JPanel comboBoxPanel;
		private JPanel wrongPassPanel;
		private JPanel wrongIDPanel;
		
		private JLabel wPass;
		private JLabel wID;
	
		private Student stud ; 
		
		private static JButton registerButton;
		
		private static JTextArea password;
		private static JTextArea id;
		
		static String depString = "dai";
		
		private boolean inputOK = false;
		private boolean inputID = false;
		private boolean inputPassword = false;
		private boolean inputUsername = false;
		
		JComboBox<Department> cmbDepList;
		JLabel lbltext = new JLabel("dai");
		
		private static Department dep;
		
		private String username;
		
		public  RegisterFrame() {
			this.setPanel();
			
			this.setContentPane(panel);
			
			this.setVisible(true);
			//Set the frame size
			this.setSize(WIDTH, HEIGHT);
			//Set the start position
			this.setLocationRelativeTo(null);
			
			this.setTitle("Register a new user");
			this.setResizable(false);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}


		private void setPanel() {
			//create a panel
			panel = new JPanel();
			//used box layout
			panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
			
			this.DepLabelAbove();
			this.ComboBoxDep();
			this.IDLabelAbove();
			this.setIDTextPanel();
			this.WrongID();
			this.passwordLabelAbove();
			this.setPasswordTextPanel();
			this.WrongPass();
			this.passwordLabelBelow();
			this.setRegisterButtonPanel();
			
			panel.add(DepLabelAbovePanel);
			panel.add(comboBoxPanel);
			panel.add(IDLabelAbovePanel);
			panel.add(IDFieldPanel);
			panel.add(wrongIDPanel);
			panel.add(PasswordLabelAbovePanel);
			panel.add(PasswordFieldPanel);
			panel.add(wrongPassPanel);
			panel.add(PasswordLabelBelowPanel);
			panel.add(RegisterButtonPanel);
			
			
			
		}
		
		public void setRegisterButtonPanel() {
			
			RegisterButtonPanel = new JPanel();
			RegisterButtonPanel.setPreferredSize(new Dimension(REGISTER_PANEL_WIDTH, REGISTER_PANEL_HEIGHT));
		
			registerButton = new JButton("Register");
			registerButton.addActionListener(this);		
			
			RegisterButtonPanel.add(registerButton);		
		}
		
		public void setPasswordTextPanel() {
			
			PasswordFieldPanel = new JPanel();
			PasswordFieldPanel.setPreferredSize(new Dimension(PASSWORD_PANEL_WIDTH , PASSWORD_PANEL_HEIGHT));
			
			
			password = new JTextArea();
			
			password.setPreferredSize(new Dimension(PASSWORD_TEXT_AREA_WIDTH, PASSWORD_TEXT_AREA_HEIGHT));
			
		
			PasswordFieldPanel.add(password);
			
			
		}
		
		public void passwordLabelAbove() {
			PasswordLabelAbovePanel = new JPanel();
			PasswordLabelAbovePanel.setPreferredSize(new Dimension(MESSAGE_PANEL_WIDTH , MESSAGE_PANEL_HEIGHT));
			
			JLabel labela = new JLabel("Enter a password :");
			
			PasswordLabelAbovePanel.add(labela);
			
		}
		public void passwordLabelBelow() {
			PasswordLabelBelowPanel = new JPanel();
			PasswordLabelBelowPanel.setPreferredSize(new Dimension(MESSAGE_PANEL_WIDTH , MESSAGE_PANEL_HEIGHT));
			
			JLabel labela = new JLabel("Remember , password must contain at least 8 characters , including one lower case and one upper case!");
			
			PasswordLabelBelowPanel.add(labela);
			
		}
		
		public void DepLabelAbove() {
			DepLabelAbovePanel = new JPanel();
			DepLabelAbovePanel.setPreferredSize(new Dimension(MESSAGE_PANEL_WIDTH , MESSAGE_PANEL_HEIGHT));
			
			JLabel labela = new JLabel("Select a department :");
			
			DepLabelAbovePanel.add(labela);
			
		}
		
		public void IDLabelAbove() {
			IDLabelAbovePanel = new JPanel();
			IDLabelAbovePanel.setPreferredSize(new Dimension(MESSAGE_PANEL_WIDTH , MESSAGE_PANEL_HEIGHT));
			
			JLabel labela = new JLabel("Enter your 5-digit ID number :");
			
			IDLabelAbovePanel.add(labela);
			
		}
		
		public void setIDTextPanel() {
			
			IDFieldPanel = new JPanel();
			IDFieldPanel.setPreferredSize(new Dimension(PASSWORD_PANEL_WIDTH , PASSWORD_PANEL_HEIGHT));
			
			
			id = new JTextArea();
			
			id.setPreferredSize(new Dimension(ID_TEXT_AREA_WIDTH, ID_TEXT_AREA_HEIGHT));
			
			IDFieldPanel.add(lbltext);
			IDFieldPanel.add(id);
			
		}
		
		public void warningMessage() {
			JOptionPane.showMessageDialog(panel,
				    "Wrong ID (and) or Password.",
				    "Error",
				    JOptionPane.WARNING_MESSAGE);
		}

		
		public static JButton getRegisterButton() {
			return registerButton;
		}
		
		public static String getPassword() {
			return password.getText();
		}
		
		
		public static String getID() {
			return id.getText();
		}
		
		public static String getUsername() {
			
			return RegisterFrame.getDepString()+RegisterFrame.getID();
		
		}
		
		public static String getPasswordRF() {
			return password.getText();
		}

		public static String getDepString() {
			return depString;
		}
		
		public static Department getDep() {
			return dep;
		}
		
		public void ComboBoxDep() {
			comboBoxPanel = new JPanel();
			comboBoxPanel.setPreferredSize(new Dimension(CB_PANEL_HEIGHT , CB_PANEL_WIDTH));
			cmbDepList = new JComboBox<>();
			for(Department i : CentralRegistry.getDepartments()  )
				cmbDepList.addItem(i);
			
			cmbDepList.setSelectedIndex(0);
			cmbDepList.addActionListener(this);
			
			comboBoxPanel.add(cmbDepList);
			
		}
		
		public void WrongID() {
			wrongIDPanel = new JPanel();
			wrongIDPanel.setPreferredSize(new Dimension(MESSAGE_PANEL_WIDTH , MESSAGE_PANEL_HEIGHT));
			
			wID = new JLabel("ID must be 5-digit from 0-9");            
	    	wID.setSize(MESSAGE_PANEL_WIDTH , MESSAGE_PANEL_HEIGHT);
	    	wID.setForeground(Color.red);
		}
		
		public void WrongPass() {
			wrongPassPanel = new JPanel();
			wrongPassPanel.setPreferredSize(new Dimension(MESSAGE_PANEL_WIDTH , MESSAGE_PANEL_HEIGHT));
			
			wPass = new JLabel("Incorrect password!");           
			wPass.setSize(MESSAGE_PANEL_WIDTH , MESSAGE_PANEL_HEIGHT);
			wPass.setForeground(Color.red);
		}
		
		public void addWarnMess(JLabel label) {
			if (label.equals(wPass))
				wrongPassPanel.add(label);
			else
				wrongIDPanel.add(label);
		}
		public void removeWarnMess(JLabel label) {
			if (label.equals(wPass))
				wrongPassPanel.remove(label);
			else
				wrongIDPanel.remove(label);
		}
		
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource().equals(cmbDepList)) {
				Department cb = (Department) cmbDepList.getSelectedItem();
				for(Department i : CentralRegistry.getDepartments()  )
					if ( cb.getName() == i.getName()) {
						lbltext.setText(i.getPrefix());
						
						depString = i.getPrefix();
						dep = i;
						
						}
					
			}
		
		 if (e.getSource() == registerButton) {
		  
			 dep = (Department) cmbDepList.getSelectedItem();
			if( ValidationCheck.CheckPassword(getPasswordRF()) )
			{
				inputPassword = true;
				removeWarnMess(wPass);
			}
			else {
				addWarnMess(wPass);
				inputPassword = false;
			}
			
			if(ValidationCheck.CheckID(getID()))
			{
				inputID = true;
				removeWarnMess(wID);
			}
			else {
				addWarnMess(wID);
				inputID = false;
			}
			username = depString+id;
			Student stud = LogRegCheck.checkUsername(username);
			if(stud != null)
				inputUsername = false;
			else 
				inputUsername = true;
			repaint();
			revalidate();
			
			if(inputPassword && inputID && inputUsername) {
				stud = CentralRegistry.registerNewUser();
				//set window invisible 
				dispose();
				//set visible next window
				new InputDataFrame(stud);
			}
		 }		
	}
}