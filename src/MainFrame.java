import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;


public class MainFrame extends JFrame{
	
	private static final int WIDTH = 1280;
	private static final int HEIGHT = 720;
	
	private static final int MENU_WIDTH = WIDTH-WIDTH*1/10;
	private static final int MENU_HEIGHT = HEIGHT*1/10;
	
	private static final int TIPS1_WIDTH = WIDTH-WIDTH*1/10;
	private static final int TIPS1_HEIGHT = HEIGHT*1/10;
	
	private static final int TIPS2_WIDTH = WIDTH-WIDTH*1/10;
	private static final int TIPS2_HEIGHT = HEIGHT*6/7-HEIGHT*1/10;
	
	
	private JPanel panel;
	private JPanel menuPanel;
	private JPanel tipsPanel1;
	private JPanel tipsPanel2;
	
	private JButton dataEditButton;
	private JButton changeCountriesButton;
	private JButton logoutButton;
	private JComboBox countriesList;
	private JButton OkButton;
	private ButtonListener listener;
	
	private JLabel actualTips;
	private String actualTip;
	
	
	public MainFrame() {
		
		
		this.setPanel();
		
		
		
		this.setContentPane(panel);
		
		this.setVisible(true);
		this.setSize(WIDTH, HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Main Screen");
		this.setResizable(false);
		
	}
	
	private void setPanel() {
		
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		this.setMenuPanel();
		this.setTipsPanel1();
		this.setTipsPanel2();
		
		panel.add(menuPanel);
		panel.add(tipsPanel1);
		panel.add(tipsPanel2);
		
	}
	
	private void setMenuPanel() {
		
		menuPanel = new JPanel();
		
		menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.X_AXIS));
		
		dataEditButton = new JButton("Edit personal info");
		changeCountriesButton = new JButton("Change chosen countries");
		logoutButton = new JButton("Logout");
		
		listener = new ButtonListener();
		
		dataEditButton.addActionListener(listener);
		changeCountriesButton.addActionListener(listener);
		logoutButton.addActionListener(listener);
		
		menuPanel.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder(), "Menu", TitledBorder.TOP, TitledBorder.TOP));
		menuPanel.setPreferredSize(new Dimension(MENU_WIDTH, MENU_HEIGHT));
		
		menuPanel.add(Box.createRigidArea(new Dimension(50,50)));
		menuPanel.add(dataEditButton);
		menuPanel.add(Box.createRigidArea(new Dimension(50,50)));
		menuPanel.add(changeCountriesButton);
		menuPanel.add(Box.createRigidArea(new Dimension(50,50)));
		menuPanel.add(logoutButton);
		menuPanel.add(Box.createRigidArea(new Dimension(50,50)));
		
		
	}
	
	private void setTipsPanel1() {
		
		String country1 = "country1";
		String country2 = "country2";
		String country3 = "country3";
		actualTip = "getTips";
		
		tipsPanel1 = new JPanel();
		tipsPanel1.setLayout(new BoxLayout(tipsPanel1, BoxLayout.X_AXIS));
		
		listener = new ButtonListener();
		
		JLabel tipsLabel = new JLabel("Here you can find tips for improving "
				+ "your Erasmus score for each of your chosen countries");
		
		
		String[] chosenCountries = {country1,country2,country3};
		
		countriesList = new JComboBox(chosenCountries);
		countriesList.addActionListener(listener);
		
		OkButton = new JButton("OK");
		OkButton.addActionListener(listener);
		
		tipsPanel1.setPreferredSize(new Dimension(TIPS1_WIDTH, TIPS1_HEIGHT));
		
		
		tipsPanel1.add(Box.createRigidArea(new Dimension(50,50)));
		tipsPanel1.add(tipsLabel);
		tipsPanel1.add(Box.createRigidArea(new Dimension(50,50)));
		tipsPanel1.add(countriesList);
		tipsPanel1.add(Box.createRigidArea(new Dimension(200,50)));
		tipsPanel1.add(OkButton);
		tipsPanel1.add(Box.createRigidArea(new Dimension(50,50)));
		
		
	}
	
	private void setTipsPanel2() {
		
		tipsPanel2 = new JPanel();

		JLabel actualTips = new JLabel(actualTip);
		
		tipsPanel2.setPreferredSize(new Dimension(TIPS2_WIDTH, TIPS2_HEIGHT));
		tipsPanel2.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder(), "Tips", TitledBorder.TOP, TitledBorder.TOP));
		
	}
	
	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource().equals(dataEditButton)) {
				
			}
			else if(e.getSource().equals(changeCountriesButton)) {
				
			}
			else if(e.getSource().equals(logoutButton)) {
				
			}
			else if(e.getSource().equals(OkButton)) {
				tipsPanel2.add(actualTips);
				
			}
			else if(e.getSource().equals(countriesList)) {
				JComboBox cb = (JComboBox) e.getSource();
				actualTip = (String) cb.getSelectedItem();
				
			}
			
				
			
		}
			
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
