import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

@SuppressWarnings("serial")
public class SecretariatFrame extends JFrame{

	// Window and main panel resolution
	private static final int WIDTH = 1280;
	private static final int HEIGHT = 720;
	
	// Resolutions of the department list and the exit button panels
	private static final int DEP_LIST_PANEL_WIDTH = WIDTH*3/10;
	private static final int DEP_LIST_PANEL_HEIGHT = HEIGHT*4/5;
	private static final int DEP_BUTTON_PANEL_WIDTH = WIDTH*3/10;
	private static final int DEP_BUTTON_PANEL_HEIGHT = HEIGHT*1/10;
	
	// Resolutions of the student list and the details for every student 
	private static final int DET_PANEL_WIDTH = WIDTH*3/5;
	private static final int DET_PANEL_HEIGHT = HEIGHT*4/5;
	private static final int INFO_BUTTON_PANEL_WIDTH = WIDTH*3/5;
	private static final int INFO_BUTTON_PANEL_HEIGHT = HEIGHT*1/10;
	
	// Resolution of the list with the departments on the department panel
	private static final int DEP_LIST_WIDTH = DEP_LIST_PANEL_WIDTH*4/5;
	private static final int DEP_LIST_HEIGHT = DEP_LIST_PANEL_HEIGHT*1/2;
	
	// Resolutions of the list and text area on the information panel
	private static final int STUD_INFO_LIST_WIDTH = DET_PANEL_WIDTH*3/5;
	private static final int STUD_INFO_LIST_HEIGHT = DET_PANEL_HEIGHT*2/5;
	private static final int STUD_DET_TEXT_AREA_WIDTH = DET_PANEL_WIDTH*4/5;
	private static final int STUD_DET_TEXT_AREA_HEIGHT = DET_PANEL_HEIGHT*1/10;
	
	
	private JPanel panel;
	private JPanel departmentListPanel;
	private JPanel departmentButtonPanel;
	private JPanel detailsPanel;
	private JPanel infoButtonPanel;
	
	private JButton nextDepartmentButton;
	private JButton previousDepartmentButton;
	private JButton logoutButton;
	private JButton exitButton;
	private ButtonListener actionListener;

	private JList<Department> departmentList;
	private DefaultListModel<Department> departmentModel;
	private JList<Student> studentInfoList;
	private DefaultListModel<Student> studentInfoModel;
	private ListListener listListener;
	
	private JTextField selectedDepartment;
	private JTextArea studentDetailsTextArea;

	
	// Constructor of the Secretariat Frame
	public SecretariatFrame() {
		
		this.setPanel();
		
		this.setContentPane(panel);
		
		this.setVisible(true);
		this.setSize(WIDTH, HEIGHT);
		this.setResizable(false);
		this.setTitle("Secretariat");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	// The main panel sets the two subpanels 
	private void setPanel() {
		
		panel = new JPanel();
		
		
		this.setDepartmentListPanel();
		this.setDetailsPanel();
		this.setDepartmentButtonPanel();
		this.setInfoButtonPanel();
		
		panel.add(departmentListPanel);
		panel.add(detailsPanel);
		panel.add(departmentButtonPanel);
		panel.add(infoButtonPanel);
		
	}
	
	
	// The department list panel sets the size of the department list 
	private void setDepartmentListPanel() {
		
		departmentListPanel = new JPanel();
		departmentListPanel.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder(), "Departments", TitledBorder.TOP, TitledBorder.TOP));
		departmentListPanel.setPreferredSize(new Dimension(DEP_LIST_PANEL_WIDTH, DEP_LIST_PANEL_HEIGHT));
		departmentListPanel.setLayout(new GridBagLayout());
		
		departmentModel = new DefaultListModel<>();
		
		for(Department department: CentralRegistry.getDepartments())
			departmentModel.addElement(department);

		departmentList = new JList<>();
		departmentList.setPreferredSize(new Dimension(DEP_LIST_WIDTH, DEP_LIST_HEIGHT));
		departmentList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		departmentList.setModel(departmentModel);
		listListener = new ListListener();
		departmentList.addListSelectionListener(listListener);
		
		departmentListPanel.add(departmentList);
	}
	
	private void setDepartmentButtonPanel() {
		
		departmentButtonPanel = new JPanel();
		departmentButtonPanel.setBorder(BorderFactory.createEtchedBorder());
		departmentButtonPanel.setPreferredSize(new Dimension(DEP_BUTTON_PANEL_WIDTH, DEP_BUTTON_PANEL_HEIGHT));

		logoutButton = new JButton("Logout");
		exitButton = new JButton("Exit");
		
		actionListener = new ButtonListener();
		logoutButton.addActionListener(actionListener);
		exitButton.addActionListener(actionListener);
		
		departmentButtonPanel.add(logoutButton);
		departmentButtonPanel.add(exitButton);
	}
	
	
	
	private void setDetailsPanel() {
		
		detailsPanel = new JPanel();
		detailsPanel.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder(), "Students", TitledBorder.TOP, TitledBorder.TOP));
		detailsPanel.setPreferredSize(new Dimension(DET_PANEL_WIDTH, DET_PANEL_HEIGHT));
		
		detailsPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(25, 10, 25, 10);
		
		selectedDepartment = new JTextField(20);
		selectedDepartment.setHorizontalAlignment(JTextField.CENTER);
		selectedDepartment.setEditable(false);
		selectedDepartment.setBorder(null);
		selectedDepartment.setText("Select a Department");
		selectedDepartment.setFont(new Font("SansSerif", Font.ITALIC, 30));
		
		studentInfoModel = new DefaultListModel<>();

		studentInfoList = new JList<>();
		studentInfoList.setPreferredSize(new Dimension(STUD_INFO_LIST_WIDTH, STUD_INFO_LIST_HEIGHT));
		studentInfoList.setModel(studentInfoModel);
		listListener = new ListListener();
		studentInfoList.addListSelectionListener(listListener);
		
		studentDetailsTextArea = new JTextArea();
		studentDetailsTextArea.setPreferredSize(new Dimension(STUD_DET_TEXT_AREA_WIDTH, STUD_DET_TEXT_AREA_HEIGHT));
		studentDetailsTextArea.setEditable(false);
		
		gbc.gridy = 0;
		detailsPanel.add(selectedDepartment, gbc);
		gbc.gridy = 1;
		detailsPanel.add(studentInfoList, gbc);
		gbc.gridy = 2;
		detailsPanel.add(studentDetailsTextArea, gbc);
	}
	
	
	private void setInfoButtonPanel() {
		
		infoButtonPanel = new JPanel();
		infoButtonPanel.setBorder(BorderFactory.createEtchedBorder());
		infoButtonPanel.setPreferredSize(new Dimension(INFO_BUTTON_PANEL_WIDTH, INFO_BUTTON_PANEL_HEIGHT));
		
		previousDepartmentButton = new JButton("Previous");
		nextDepartmentButton = new JButton("Next");
		
		actionListener = new ButtonListener();
		previousDepartmentButton.addActionListener(actionListener);
		nextDepartmentButton.addActionListener(actionListener);		
		
		infoButtonPanel.add(previousDepartmentButton);
		infoButtonPanel.add(nextDepartmentButton);
	}
	
	
	
	
	class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource().equals(logoutButton)) {
				dispose();
				new HomeFrame();
			}
			else if(e.getSource().equals(exitButton)) {
				int answer = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Confirm", JOptionPane.YES_NO_OPTION);
				if (answer == JOptionPane.YES_OPTION)
					System.exit(0);
			}
			else if(e.getSource().equals(previousDepartmentButton)) {
				if(departmentList.getSelectedIndex()-1 == -1)
					departmentList.setSelectedIndex(CentralRegistry.getDepartments().size()-1);
				else
					departmentList.setSelectedIndex(
							(departmentList.getSelectedIndex()-1)%CentralRegistry.getDepartments().size());
			}
			else if(e.getSource().equals(nextDepartmentButton))
				departmentList.setSelectedIndex(
						(departmentList.getSelectedIndex()+1)%CentralRegistry.getDepartments().size());
			
		}
		
	}
	
	class ListListener implements ListSelectionListener{

		@Override
		public void valueChanged(ListSelectionEvent e) {

			if(e.getSource().equals(departmentList)) {
				selectedDepartment.setText(departmentList.getSelectedValue().getName());
				studentInfoModel.removeAllElements();
				for(Student student: departmentList.getSelectedValue().getStudentslist())
					studentInfoModel.addElement(student);
			}
			else if(e.getSource().equals(studentInfoList))
				studentDetailsTextArea.setText(studentInfoList.getSelectedValue().getDetails());
		}
		
	}
}
