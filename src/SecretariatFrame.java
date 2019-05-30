import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.function.IntFunction;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class SecretariatFrame extends JFrame{

	private static final int WIDTH = 1280;
	private static final int HEIGHT = 720;
	
	private static final int DEP_PANEL_WIDTH = WIDTH*1/3;
	private static final int DEP_PANEL_HEIGHT = HEIGHT;
	private static final int INFO_PANEL_WIDTH = WIDTH*2/3;
	private static final int INFO_PANEL_HEIGHT = HEIGHT;
	
	private static final int DEP_LIST_PANEL_WIDTH = DEP_PANEL_WIDTH;
	private static final int DEP_LIST_PANEL_HEIGHT = DEP_PANEL_HEIGHT*9/10;
	private static final int DEP_BUTTON_PANEL_WIDTH = DEP_PANEL_WIDTH;
	private static final int DEP_BUTTON_PANEL_HEIGHT = DEP_PANEL_HEIGHT*1/10;
	
	private static final int DET_PANEL_WIDTH = INFO_PANEL_WIDTH;
	private static final int DET_PANEL_HEIGHT = INFO_PANEL_HEIGHT*9/10;
	private static final int INFO_BUTTON_PANEL_WIDTH = INFO_PANEL_WIDTH;
	private static final int INFO_BUTTON_PANEL_HEIGHT = INFO_PANEL_HEIGHT*1/10;
	
	private static final int DEP_LIST_WIDTH = DEP_LIST_PANEL_WIDTH*4/5;
	private static final int DEP_LIST_HEIGHT = DEP_LIST_PANEL_HEIGHT*1/2;
	
	private static final int STUD_INFO_LIST_WIDTH = DET_PANEL_WIDTH*3/5;
	private static final int STUD_INFO_LIST_HEIGHT = DET_PANEL_HEIGHT*2/5;
	private static final int STUD_DET_TEXT_AREA_WIDTH = DET_PANEL_WIDTH*4/5;
	private static final int STUD_DET_TEXT_AREA_HEIGHT = DET_PANEL_HEIGHT*1/10;
	
	
	private JPanel panel;
	private JPanel departmentsPanel;
	private JPanel infoPanel;
	private JPanel departmentListPanel;
	private JPanel departmentButtonPanel;
	private JPanel detailsPanel;
	private JPanel infoButtonPanel;
	
	private JButton nextDepartmentButton;
	private JButton previousDepartmentButton;
	private JButton exitButton;

	private JList<String> departmentList;
	private DefaultListModel<String> departmentModel;
	private JList<String> studentInfoList;
	private DefaultListModel<String> studentInfoModel;
	
	private JTextArea studentDetailsTextArea;

	
	
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
		departmentsPanel.setPreferredSize(new Dimension(DEP_PANEL_WIDTH, DEP_PANEL_HEIGHT));
		departmentsPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		this.setDepartmentListPanel();
		this.setDepartmentButtonPanel();
		departmentsPanel.add(departmentListPanel);
		departmentsPanel.add(departmentButtonPanel);
	}
	
	private void setInfoPanel() {
		
		infoPanel = new JPanel();
		infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
		infoPanel.setPreferredSize(new Dimension(INFO_PANEL_WIDTH, INFO_PANEL_HEIGHT));
		infoPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		this.setDetailsPanel();
		this.setInfoButtonPanel();
		infoPanel.add(detailsPanel);
		infoPanel.add(infoButtonPanel);
	}
	
	
	
	private void setDepartmentListPanel() {
		
		departmentListPanel = new JPanel();
		departmentListPanel.setPreferredSize(new Dimension(DEP_LIST_PANEL_WIDTH, DEP_LIST_PANEL_HEIGHT));
		departmentListPanel.setLayout(new GridBagLayout());
		
		departmentModel = new DefaultListModel<>();
		
		//for(Department department: CentralRegistry.getDepartments())
				//	departmentModel.addElement(department.getName()); 

		departmentList = new JList<>();
		departmentList.setPreferredSize(new Dimension(DEP_LIST_WIDTH, DEP_LIST_HEIGHT));
		departmentList.setModel(departmentModel);
		
		departmentListPanel.add(departmentList);
	}
	
	private void setDepartmentButtonPanel() {
		
		departmentButtonPanel = new JPanel();
		departmentButtonPanel.setPreferredSize(new Dimension(DEP_BUTTON_PANEL_WIDTH, DEP_BUTTON_PANEL_HEIGHT));

		exitButton = new JButton("Exit");
		
		departmentButtonPanel.add(exitButton);
	}
	
	
	
	private void setDetailsPanel() {
		
		detailsPanel = new JPanel();
		detailsPanel.setPreferredSize(new Dimension(DET_PANEL_WIDTH, DET_PANEL_HEIGHT));
		detailsPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(25, 10, 25, 10);
		
		studentInfoModel = new DefaultListModel<>();
		
		//for(Student student: CentralRegistry.getStudents())
				//	studentInfoModel.addElement(student.getInfo()); 

		studentInfoList = new JList<>();
		studentInfoList.setPreferredSize(new Dimension(STUD_INFO_LIST_WIDTH, STUD_INFO_LIST_HEIGHT));
		studentInfoList.setModel(studentInfoModel);
		
		studentDetailsTextArea = new JTextArea();
		studentDetailsTextArea.setPreferredSize(new Dimension(STUD_DET_TEXT_AREA_WIDTH, STUD_DET_TEXT_AREA_HEIGHT));
		
		gbc.gridy = 0;
		detailsPanel.add(studentInfoList, gbc);
		gbc.gridy = 1;
		detailsPanel.add(studentDetailsTextArea, gbc);
	}
	
	private void setInfoButtonPanel() {
		
		infoButtonPanel = new JPanel();
		infoButtonPanel.setPreferredSize(new Dimension(INFO_BUTTON_PANEL_WIDTH, INFO_BUTTON_PANEL_HEIGHT));
		
		previousDepartmentButton = new JButton("Previous");
		nextDepartmentButton = new JButton("Next");
		
		infoButtonPanel.add(previousDepartmentButton);
		infoButtonPanel.add(nextDepartmentButton);
	}
}
