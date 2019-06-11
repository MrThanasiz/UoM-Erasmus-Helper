import java.awt.Component;
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


@SuppressWarnings("serial")
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
	private JButton changeUniversitiesButton;
	private JButton logoutButton;
	private JComboBox<String> universitiesList;
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
	
	
	
	public MainFrame(Student stud) {
		this.stud=stud;
		if (stud.getAcademicYear()==0) {
			dispose();
			new InputDataFrame(stud);
		}
		this.setPanel();
		
		this.setContentPane(panel);
		
		this.setVisible(true);
		this.setSize(WIDTH, HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Main Screen");
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
	}
	
	private void setPanel() {
		
		panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 0, 5, 0);
		
		this.setMenuPanel();
		this.setTipsPanel1();
		this.setTipsPanel2();
    	
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
		changeUniversitiesButton = new JButton("Change chosen universities");
		logoutButton = new JButton("Logout");
		
		listener = new ButtonListener();
		
		dataEditButton.addActionListener(listener);
		changeUniversitiesButton.addActionListener(listener);
		logoutButton.addActionListener(listener);
		
		menuPanel.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder(), "Menu", TitledBorder.TOP, TitledBorder.TOP));
		menuPanel.setPreferredSize(new Dimension(MENU_WIDTH, MENU_HEIGHT));
		
		menuPanel.add(Box.createRigidArea(new Dimension(320,50)));
		menuPanel.add(dataEditButton);
		menuPanel.add(Box.createRigidArea(new Dimension(50,50)));
		menuPanel.add(changeUniversitiesButton);
		menuPanel.add(Box.createRigidArea(new Dimension(50,50)));
		menuPanel.add(logoutButton);
		menuPanel.add(Box.createRigidArea(new Dimension(320,50)));
		
		
	}
	
	private void setTipsPanel1() {
		
		universitiesList = new JComboBox<>();
		hm = stud.getScores();
		if(hm == null) {
			dispose();
			new UniversitySelectFrame(stud);
		}
		else {
			for(University uni: hm.keySet()) {
				universitiesList.addItem(uni.getName() + "  " + hm.get(uni));
				unisList.add(uni);
			}
			
		
		
		tipsPanel1 = new JPanel();
		tipsPanel1.setLayout(new BoxLayout(tipsPanel1, BoxLayout.X_AXIS));
		
		listener = new ButtonListener();
		
		JLabel tipsLabel = new JLabel("Here you can find tips for improving "
				+ "your Erasmus score for each of your chosen universities");
		
		universitiesList.addActionListener(listener);
		
		
		tipsPanel1.setPreferredSize(new Dimension(TIPS1_WIDTH, TIPS1_HEIGHT));
		
		
		tipsPanel1.add(Box.createRigidArea(new Dimension(50,50)));
		tipsPanel1.add(tipsLabel);
		tipsPanel1.add(Box.createRigidArea(new Dimension(50,50)));
		tipsPanel1.add(universitiesList);
		tipsPanel1.add(Box.createRigidArea(new Dimension(200,50)));
		tipsPanel1.add(Box.createRigidArea(new Dimension(50,50)));
		
		}
	}
	
	private void setTipsPanel2() {

		
		tipsPanel2 = new JPanel();
		
		tipsPanel2.setLayout(new BoxLayout(tipsPanel2, BoxLayout.Y_AXIS));
		

		sTipGrade = Tips.getTipGrade(stud,unisList.get(index));
		sTipFailed = Tips.getTipFailed(stud,unisList.get(index));
		sTipYear = Tips.getTipYear(stud,unisList.get(index));
		sTipEnglish = Tips.getTipLEnglish(stud,unisList.get(index));
		sTipNative = Tips.getTipLNative(stud, unisList.get(index));

		tipGrade = new JLabel(sTipGrade);
		tipFailed = new JLabel(sTipFailed);
		tipYear = new JLabel(sTipYear);
		tipEnglish = new JLabel(sTipEnglish);
		tipNative = new JLabel(sTipNative);
		
		
		
		tipsPanel2.setPreferredSize(new Dimension(TIPS2_WIDTH, TIPS2_HEIGHT));
		tipsPanel2.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder(), "Tips", TitledBorder.TOP, TitledBorder.TOP));
		
		tipGrade.setAlignmentX(Component.CENTER_ALIGNMENT);
		tipFailed.setAlignmentX(Component.CENTER_ALIGNMENT);
		tipYear.setAlignmentX(Component.CENTER_ALIGNMENT);
		tipEnglish.setAlignmentX(Component.CENTER_ALIGNMENT);
		tipNative.setAlignmentX(Component.CENTER_ALIGNMENT);

		tipsPanel2.add(Box.createRigidArea(new Dimension(1000,60)));
		tipsPanel2.add(tipGrade);
		tipsPanel2.add(Box.createRigidArea(new Dimension(1000,50)));
		tipsPanel2.add(tipFailed);
		tipsPanel2.add(Box.createRigidArea(new Dimension(1000,50)));
		tipsPanel2.add(tipYear);
		tipsPanel2.add(Box.createRigidArea(new Dimension(1000,50)));
		tipsPanel2.add(tipEnglish);
		tipsPanel2.add(Box.createRigidArea(new Dimension(1000,50)));
		tipsPanel2.add(tipNative);
		tipsPanel2.add(Box.createRigidArea(new Dimension(1000,50)));
	}
	
	
	class ButtonListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource().equals(dataEditButton)) {
				dispose();
				new InputDataFrame(stud);
			}
			else if(e.getSource().equals(changeUniversitiesButton)) {
				dispose();
				new UniversitySelectFrame(stud);
				
				
			}
			else if(e.getSource().equals(logoutButton)) {
				dispose();
				new HomeFrame();
				
				
			}
			else if(e.getSource().equals(universitiesList)) {
				index = universitiesList.getSelectedIndex();
				sTipGrade = Tips.getTipGrade(stud,unisList.get(index));
				sTipFailed = Tips.getTipFailed(stud,unisList.get(index));
				sTipYear = Tips.getTipYear(stud,unisList.get(index));
				sTipEnglish = Tips.getTipLEnglish(stud,unisList.get(index));
				sTipNative = Tips.getTipLNative(stud, unisList.get(index));
				
				tipGrade.setText(sTipGrade);
				tipFailed.setText(sTipFailed);
				tipYear.setText(sTipYear);
				tipEnglish.setText(sTipEnglish);
				tipNative.setText(sTipNative);
				
				repaint();
				revalidate();
			}
		}
	}
}
