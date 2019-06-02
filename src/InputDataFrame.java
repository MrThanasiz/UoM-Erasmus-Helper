import javax.swing.*;    
import java.awt.event.*;    
public class InputDataFrame { 
	//Frame Options
	private static final int WIDTH=1280;
	private static final int HEIGHT=720;
	
	//"Input Data" Label
	private static final int L_X=WIDTH*21/40;
	private static final int L_Y=HEIGHT*1/10;
	
	//Data Fields
	private static final int D_WIDTH=WIDTH*15/100;
	private static final int D_HEIGHT=HEIGHT*5/100;
	private static final int D_X=WIDTH*40/100;
	private static final int D1_Y=HEIGHT*10/100;
	private static final int D2_Y=HEIGHT*20/100;
	private static final int D3_Y=HEIGHT*30/100;
	private static final int D4_Y=HEIGHT*43/100;
	private static final int D4L_X=WIDTH*58/100;
	private static final int D4L_WIDTH=WIDTH*5/100;
	private static final int D42_Y=HEIGHT*50/100;
	private static final int D43_Y=HEIGHT*57/100;
	private static final int D44_Y=HEIGHT*64/100;
	private static final int D45_Y=HEIGHT*71/100;
	private static final int D46_Y=HEIGHT*78/100;
	private static final int D47_Y=HEIGHT*85/100;
	
	//Data Fields Labels
	
	private static final int DL_X=WIDTH*39/100;
	private static final int DL1_Y=HEIGHT*25/100;
	private static final int DL2_Y=HEIGHT*45/100;
	private static final int DL3_Y=HEIGHT*65/100;
	private static final int DL4_Y=HEIGHT*90/100;
	
	
	
	//Languages add language
	private static final int LB_X=WIDTH*60/100;
	private static final int LB_Y=HEIGHT*30/100;
	private static final int LB_WIDTH=WIDTH*10/100;
	private static final int LB_HEIGHT=HEIGHT*5/100;
	
	//Next button
	private static final int NB_X=WIDTH*60/100;
	private static final int NB_Y=HEIGHT*80/100;
	private static final int NB_WIDTH=WIDTH*10/100;
	private static final int NB_HEIGHT=HEIGHT*5/100;
	
	
	
	JFrame f;    
	InputDataFrame(){
		//Frame Options
	    f=new JFrame("Input Data");
	    f.setLayout(null);    
	    f.setSize(WIDTH,HEIGHT);    
	    
	    
	    //"Choose Country" Label
	    final JLabel label = new JLabel("Edit your profile");  
	    label.setHorizontalAlignment(JLabel.TRAILING);  
	    label.setSize(L_X,L_Y);
	    f.add(label);
	    
	    //Data input fields
	    final JTextField averageField=new JTextField("");    
	    averageField.setBounds(D_X,D1_Y,D_WIDTH,D_HEIGHT); 
	    f.add(averageField);
	    final JTextField failedField=new JTextField("");   
	    failedField.setBounds(D_X,D2_Y,D_WIDTH,D_HEIGHT);
	    f.add(failedField);	
	    
	    String years[]={"1","2","3","4","5+"};
	    final JComboBox<String> yearField=new JComboBox<String>(years);    
	    yearField.setBounds(D_X,D3_Y,D_WIDTH,D_HEIGHT); 
	    f.add(yearField);
	    
	    String languages[]= {"English","French","German","Spanish"};
	    final JComboBox<String> langField=new JComboBox<String>(languages);    
	    langField.setBounds(D_X,D4_Y,D_WIDTH,D_HEIGHT); 
	    f.add(langField);
	    final JComboBox<String> langField2=new JComboBox<String>(languages);    
	    langField2.setBounds(D_X,D42_Y,D_WIDTH,D_HEIGHT); 
	    f.add(langField2);
	    final JComboBox<String> langField3=new JComboBox<String>(languages);    
	    langField3.setBounds(D_X,D43_Y,D_WIDTH,D_HEIGHT); 
	    f.add(langField3);
	    
	    String level[]= {"B1","B2","C1","C2"};
	    final JComboBox<String> levelField=new JComboBox<String>(level);    
	    levelField.setBounds(D4L_X,D4_Y,D4L_WIDTH,D_HEIGHT); 
	    f.add(levelField);
	    final JComboBox<String> levelField2=new JComboBox<String>(level);    
	    levelField2.setBounds(D4L_X,D42_Y,D4L_WIDTH,D_HEIGHT); 
	    f.add(levelField2);
	    final JComboBox<String> levelField3=new JComboBox<String>(level);    
	    levelField3.setBounds(D4L_X,D43_Y,D4L_WIDTH,D_HEIGHT); 
	    f.add(levelField3);
	    
	    
	    
	    final JLabel l1 = new JLabel("Passed Classes Avarage:");          
	    l1.setHorizontalAlignment(JLabel.TRAILING);  
	    l1.setSize(DL_X,DL1_Y);
	    f.add(l1);
	    
	    final JLabel l2 = new JLabel("Number of Failed Classes after September:");          
	    l2.setHorizontalAlignment(JLabel.TRAILING);  
	    l2.setSize(DL_X,DL2_Y);
	    f.add(l2);
	    
	    final JLabel l3 = new JLabel("Year:");          
	    l3.setHorizontalAlignment(JLabel.TRAILING);  
	    l3.setSize(DL_X,DL3_Y);
	    f.add(l3);
	    
	    final JLabel l4 = new JLabel("Language Degree:");          
	    l4.setHorizontalAlignment(JLabel.TRAILING);  
	    l4.setSize(DL_X,DL4_Y);
	    f.add(l4);
	    
	    
	    //Next button
	    JButton buttonNext=new JButton("Get Tips");  
	    buttonNext.setBounds(NB_X,NB_Y,NB_WIDTH,NB_HEIGHT);
	    f.add(buttonNext);
	    buttonNext.addActionListener(new ActionListener() {  
	        public void actionPerformed(ActionEvent e) {
	        	//tipsFrame();
	        	//^^uncomment this when tipsFrame() is ready.
	        }
	    });
	        
	    f.setVisible(true);  
	           
	}
}