import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

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
	
	private static final int MENU_WIDTH = WIDTH*9/10;
	private static final int MENU_HEIGHT = HEIGHT*1/10;
	
	private static final int TIPS1_WIDTH = WIDTH*9/10;
	private static final int TIPS1_HEIGHT = HEIGHT*1/10;
	
	private static final int TIPS2_WIDTH = WIDTH*9/10;
	private static final int TIPS2_HEIGHT = HEIGHT*7/10;
	
	private Student stud;
	
	private JPanel panel;
	private JPanel menuPanel;
	private JPanel tipsPanel1;
	private JPanel tipsPanel2;
	
	private JButton dataEditButton;
	private JButton changeCountriesButton;
	private JButton logoutButton;
	private JComboBox<String> countriesList;
	private JButton OkButton;
	private ButtonListener listener;
	
	private JLabel tipYear;
	private JLabel tipGrade;
	private JLabel tipFailed;
	private JLabel tipEnglish;
	private JLabel tipNative;
	
	private String sTipYear;
	private String sTipGrade;
	private String sTipFailed;
	private String sTipEnglish;
	private String sTipNative;
	
	private int index=0;
	private ArrayList<University> unisList= new ArrayList<University>();
	private HashMap<University,Double> hm;
	
	private University chosen=null;
	private ArrayList<String> chosenCountries;
	
	
	public MainFrame(Student stud) {
		this.stud=stud;
		this.setPanel(stud);
		
		this.setContentPane(panel);
		
		this.setVisible(true);
		this.setSize(WIDTH, HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Main Screen");
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
	}
	
	private void setPanel(Student stud) {
		
		panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 0, 5, 0);
		
		this.setMenuPanel();
		this.setTipsPanel1(stud);
		this.setTipsPanel2(stud);
    	
		gbc.gridy = 0;
		panel.add(menuPanel, gbc);
		gbc.gridy = 1;
		panel.add(tipsPanel1, gbc);
		gbc.gridy = 2;
		panel.add(tipsPanel2, gbc);
		
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
		
		menuPanel.add(Box.createRigidArea(new Dimension(320,50)));
		menuPanel.add(dataEditButton);
		menuPanel.add(Box.createRigidArea(new Dimension(50,50)));
		menuPanel.add(changeCountriesButton);
		menuPanel.add(Box.createRigidArea(new Dimension(50,50)));
		menuPanel.add(logoutButton);
		menuPanel.add(Box.createRigidArea(new Dimension(320,50)));
		
		
	}
	
	private void setTipsPanel1(Student stud) {
		
		countriesList = new JComboBox<String>();

		hm = stud.getScores();
		
		for(University uni: hm.keySet()) {
			countriesList.addItem(uni.getName());
			unisList.add(uni);
			
		}
		for(University nam: unisList) {
			//System.out.print(nam.getName());
		}
		
			
		
		
		tipsPanel1 = new JPanel();
		tipsPanel1.setLayout(new BoxLayout(tipsPanel1, BoxLayout.X_AXIS));
		
		listener = new ButtonListener();
		
		JLabel tipsLabel = new JLabel("Here you can find tips for improving "
				+ "your Erasmus score for each of your chosen countries");
		
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
	
	private void setTipsPanel2(Student stud) {

		
		tipsPanel2 = new JPanel();
		
		tipsPanel2.setLayout(new BoxLayout(tipsPanel2, BoxLayout.Y_AXIS));
		

		sTipGrade = Tips.getTipGrade(stud,unisList.get(index));
		sTipFailed = Tips.getTipFailed(stud,unisList.get(index));
		sTipYear = Tips.getTipYear(stud,unisList.get(index));
		sTipEnglish = Tips.getTipLEnglish(stud,unisList.get(index));
		sTipNative = Tips.getTipLNative(stud, unisList.get(index));

		JLabel tipGrade = new JLabel(sTipGrade);
		JLabel tipFailed = new JLabel(sTipFailed);
		JLabel tipYear = new JLabel(sTipYear);
		JLabel tipEnglish = new JLabel(sTipEnglish);
		JLabel tipNative = new JLabel(sTipNative);
		
		
		
		tipsPanel2.setPreferredSize(new Dimension(TIPS2_WIDTH, TIPS2_HEIGHT));
		tipsPanel2.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder(), "Tips", TitledBorder.TOP, TitledBorder.TOP));

		tipsPanel2.add(tipGrade);
		tipsPanel2.add(tipFailed);
		tipsPanel2.add(tipYear);
		tipsPanel2.add(tipEnglish);
		tipsPanel2.add(tipNative);
		
	}
	
	
	
	
	class ButtonListener implements ActionListener {
		
		

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource().equals(dataEditButton)) {
				dispose();
				new InputDataFrame(stud);
			}
			else if(e.getSource().equals(changeCountriesButton)) {
				dispose();
				new UniversitySelectFrame(stud);
				
				
			}
			else if(e.getSource().equals(logoutButton)) {
				dispose();
				new HomeFrame();
				
				
			}
			else if(e.getSource().equals(OkButton)) {
				
				sTipNative = Tips.getTipLNative(stud, unisList.get(index));
				
				
				
			}
			else if(e.getSource().equals(countriesList)) {
				JComboBox cb = (JComboBox) e.getSource();
				index = cb.getSelectedIndex();
				//System.out.println(index);
				
				
				
				
				
				
			}
		}
	}
}
