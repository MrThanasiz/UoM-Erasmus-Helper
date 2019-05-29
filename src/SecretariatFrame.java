import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SecretariatFrame extends JFrame{

	private static final int WIDTH = 1280;
	private static final int HEIGHT = 720;
	
	private JPanel panel;
	private JPanel departmentsPanel;
	private JPanel infoPanel;
	
	private JButton nextDepartmentButton;
	private JButton previousDepartmentButton;
	private JButton exitButton;

	private JList<String> list;
	private DefaultListModel<String> model;

	public SecretariatFrame() {
		
		this.setDepartmentsPanel();
		this.setInfoPanel();
		this.setPanel();
		
		this.setContentPane(panel);
		
		this.setVisible(true);
		this.setSize(WIDTH, HEIGHT);
		this.setResizable(false);
		this.setTitle("Secretariat");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void setPanel() {
		
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		panel.add(departmentsPanel);
		panel.add(infoPanel);
	}
	
	private void setDepartmentsPanel() {
		
		departmentsPanel = new JPanel();
		
		list = new JList<>();
		model = new DefaultListModel<>();
		
		exitButton = new JButton("Exit");
		
		
		//for(Department department: CentralRegistry.getDepartments())
		//	model.addElement(department.getName()); 
		
		list.setModel(model);
		list.setPreferredSize(new Dimension(WIDTH*1/4, HEIGHT*1/4));

		departmentsPanel.add(list);
		departmentsPanel.add(exitButton);


		departmentsPanel.setPreferredSize(new Dimension(WIDTH*1/3, HEIGHT));
		departmentsPanel.setBorder(BorderFactory.createLineBorder(Color.black));
	}
	
	private void setInfoPanel() {
		
		infoPanel = new JPanel();
		
		previousDepartmentButton = new JButton("Previous");
		nextDepartmentButton = new JButton("Next");
		
		
		infoPanel.add(previousDepartmentButton);
		infoPanel.add(nextDepartmentButton);
		
		
		infoPanel.setPreferredSize(new Dimension(WIDTH*2/3, HEIGHT));
		infoPanel.setBorder(BorderFactory.createLineBorder(Color.black));
	}
}
