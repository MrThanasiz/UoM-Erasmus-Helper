import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	
	private static final int MENU_WIDTH = WIDTH*1/5;
	private static final int MENU_HEIGHT = HEIGHT-HEIGHT*1/10;
	
	private static final int TIPS_WIDTH = (WIDTH*4/5)-WIDTH*1/10;
	private static final int TIPS_HEIGHT = HEIGHT-HEIGHT*1/10;
	
	
	private JPanel panel;
	private JPanel menuPanel;
	private JPanel tipsPanel;
	
	private JButton dataEditButton;
	private JButton changeCountriesButton;
	private JButton logoutButton;
	private JComboBox countriesList;
	private ButtonListener listener;
	
	
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
		
		this.setMenuPanel();
		this.setTipsPanel();
		
		panel.add(menuPanel);
		panel.add(tipsPanel);
		
	}
	
	private void setMenuPanel() {
		
		menuPanel = new JPanel();
		
		menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
		
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
		
		menuPanel.add(Box.createRigidArea(new Dimension(80,150)));
		menuPanel.add(dataEditButton);
		menuPanel.add(Box.createRigidArea(new Dimension(80,100)));
		menuPanel.add(changeCountriesButton);
		menuPanel.add(Box.createRigidArea(new Dimension(80,100)));
		menuPanel.add(logoutButton);
		
		
	}
	
	private void setTipsPanel() {
		
		String country1 = "country1";
		String country2 = "country2";
		String country3 = "country3";
		
		tipsPanel = new JPanel();
		
		listener = new ButtonListener();
		
		JLabel tipsLabel = new JLabel("Here you can find tips for improving "
				+ "your Erasmus score for each of your chosen countries");
		String[] chosenCountries = {country1,country2,country3};
		countriesList = new JComboBox(chosenCountries);
		
		
		
		tipsPanel.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder(), "Tips", TitledBorder.TOP, TitledBorder.TOP));
		tipsPanel.setPreferredSize(new Dimension(TIPS_WIDTH, TIPS_HEIGHT));
		
		tipsPanel.add(tipsLabel);
		tipsPanel.add(countriesList);
		
		
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
			else if(e.getSource() == (countriesList)) {
				
				
				
			}
				
			
		}
			
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
