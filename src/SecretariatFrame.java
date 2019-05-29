import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;


//Σταθερες για τα μεγεθη
//Σωστη τοποθετηση παραθυρων
@SuppressWarnings("serial")
public class SecretariatFrame extends JFrame{

	private static final int WIDTH = 1280;
	private static final int HEIGHT = 720;
	
	private JPanel panel;
	private JPanel departmentsPanel;
	private JPanel infoPanel;
	private JPanel departmentListPanel;
	private JPanel departmentButtonPanel;
	private JPanel infoListPanel;
	private JPanel infoButtonPanel;
	
	private JButton nextDepartmentButton;
	private JButton previousDepartmentButton;
	private JButton exitButton;

	private JList<String> departmentList;
	private DefaultListModel<String> departmentModel;
	private JList<String> studentInfoList;
	private DefaultListModel<String> studentInfoModel;

	public SecretariatFrame() {
		
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

		this.setDepartmentsPanel();
		this.setInfoPanel();
		panel.add(departmentsPanel);
		panel.add(infoPanel);
	}
	
	private void setDepartmentsPanel() {
		
		departmentsPanel = new JPanel();
		
		departmentsPanel.setLayout(new BoxLayout(departmentsPanel, BoxLayout.Y_AXIS));
		departmentsPanel.setPreferredSize(new Dimension(WIDTH*1/3, HEIGHT));
		departmentsPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		this.setDepartmentListPanel();
		this.setDepartmentButtonPanel();
		departmentsPanel.add(departmentListPanel);
		departmentsPanel.add(departmentButtonPanel);
	}
	
	private void setInfoPanel() {
		
		infoPanel = new JPanel();
		
		infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
		infoPanel.setPreferredSize(new Dimension(WIDTH*2/3, HEIGHT));
		infoPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		this.setInfoListPanel();
		this.setInfoButtonPanel();
		infoPanel.add(infoListPanel);
		infoPanel.add(infoButtonPanel);
	}
	
	private void setDepartmentListPanel() {
		
		departmentListPanel = new JPanel();
		departmentListPanel.setPreferredSize(new Dimension(WIDTH*1/3, HEIGHT*9/10));
		
		departmentModel = new DefaultListModel<>();
		
		//for(Department department: CentralRegistry.getDepartments())
				//	departmentModel.addElement(department.getName()); 

		departmentList = new JList<>();
		departmentList.setPreferredSize(new Dimension(WIDTH*1/4, HEIGHT*1/4));
		departmentList.setModel(departmentModel);
		
		departmentListPanel.add(departmentList);
	}
	
	private void setDepartmentButtonPanel() {
		
		departmentButtonPanel = new JPanel();
		departmentButtonPanel.setPreferredSize(new Dimension(WIDTH*1/3, HEIGHT*1/10));

		exitButton = new JButton("Exit");
		
		departmentButtonPanel.add(exitButton);
	}
	
	private void setInfoListPanel() {
		
		infoListPanel = new JPanel();
		infoListPanel.setPreferredSize(new Dimension(WIDTH*2/3, HEIGHT*9/10));
		
		studentInfoModel = new DefaultListModel<>();
		
		//for(Student student: CentralRegistry.getStudents())
				//	studentInfoModel.addElement(student.getInfo()); 

		studentInfoList = new JList<>();
		studentInfoList.setPreferredSize(new Dimension(WIDTH*1/4, HEIGHT*1/4));
		studentInfoList.setModel(studentInfoModel);
		
		infoListPanel.add(studentInfoList);
	}
	
	private void setInfoButtonPanel() {
		
		infoButtonPanel = new JPanel();
		infoButtonPanel.setPreferredSize(new Dimension(WIDTH*2/3, HEIGHT*1/10));
		
		previousDepartmentButton = new JButton("Previous");
		nextDepartmentButton = new JButton("Next");
		
		infoButtonPanel.add(previousDepartmentButton);
		infoButtonPanel.add(nextDepartmentButton);
	}
}
