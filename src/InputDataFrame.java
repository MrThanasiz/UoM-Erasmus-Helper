import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;
import java.util.HashMap;    
public class InputDataFrame { 
	//Frame Options
	private static final int WIDTH=1280;
	private static final int HEIGHT=720;
	
	//"Input Data" Label
	private static final int L_X=WIDTH*52/100;
	private static final int L_Y=HEIGHT*10/100;
	
	//Data Fields Labels
	private static final int DL_X=WIDTH*39/100;
	private static final int DLE_X=WIDTH*74/100;
	private static final int DL1_Y=HEIGHT*25/100;
	private static final int DL2_Y=HEIGHT*45/100;
	private static final int DL3_Y=HEIGHT*65/100;
	private static final int DL4_Y=HEIGHT*90/100;
	
	//Data Fields
	private static final int D_WIDTH=WIDTH*15/100;
	private static final int D_HEIGHT=HEIGHT*5/100;
	private static final int D_X=WIDTH*40/100;
	private static final int D1_Y=HEIGHT*10/100;
	private static final int D2_Y=HEIGHT*20/100;
	private static final int D3_Y=HEIGHT*30/100;
	private static final int D4L_X=WIDTH*58/100;
	private static final int D4L_WIDTH=WIDTH*5/100;
	private static final int D4_Y=HEIGHT*43/100;
	private static final int D42_Y=HEIGHT*50/100;
	private static final int D43_Y=HEIGHT*57/100;
	private static final int D44_Y=HEIGHT*64/100;
	private static final int D45_Y=HEIGHT*71/100;
	
	
	//Languages add/remove language
	private static final int LB_WIDTH=WIDTH*5/100;
	private static final int LB_HEIGHT=HEIGHT*5/100;
	private static final int LB_X=WIDTH*65/100;
	private static final int LB_Y=HEIGHT*43/100;
	
	
	//Next button
	private static final int NB_X=WIDTH*70/100;
	private static final int NB_Y=HEIGHT*80/100;
	private static final int NB_WIDTH=WIDTH*10/100;
	private static final int NB_HEIGHT=HEIGHT*5/100;
	
	
	
	JFrame f;    
	InputDataFrame(Student stud){
		//Frame Options
	    f=new JFrame("Input Data");
	    f.setLayout(null);    
	    f.setSize(WIDTH,HEIGHT);    
	    
	    
	    //Input Data Label
	    final JLabel label = new JLabel("Edit your profile");  
	    label.setHorizontalAlignment(JLabel.TRAILING);  
	    label.setSize(L_X,L_Y);
	    f.add(label);
	    
	    //Input Field Labels (Average,Failed,Year,Languages)
	    final JLabel l1 = new JLabel("Passed Classes Average:");          
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
	    
	    //Error messages (only show when there's bad input)
	    final JLabel w1 = new JLabel("(Average can be between 5 and 10)           ");          
	    w1.setHorizontalAlignment(JLabel.TRAILING);  
	    w1.setSize(DLE_X,DL1_Y);
	    w1.setForeground(Color.red);
	    
	    final JLabel w2 = new JLabel(" (Failed Classes can be between 0 and 99)");          
	    w2.setHorizontalAlignment(JLabel.TRAILING);  
	    w2.setSize(DLE_X,DL2_Y);
	    w2.setForeground(Color.red);
	    
	    //Data input fields (Average,Failed,Year)
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
	    
	    
	    //Language drop-down
	    String languages[]= {"---","English","French","German","Spanish","Other"};
	    final JComboBox<String> langField=new JComboBox<String>(languages);    
	    langField.setBounds(D_X,D4_Y,D_WIDTH,D_HEIGHT); 
	    f.add(langField);
	    final JComboBox<String> langField2=new JComboBox<String>(languages);    
	    langField2.setBounds(D_X,D42_Y,D_WIDTH,D_HEIGHT); 
	    
	    final JComboBox<String> langField3=new JComboBox<String>(languages);    
	    langField3.setBounds(D_X,D43_Y,D_WIDTH,D_HEIGHT); 
	    
	    final JComboBox<String> langField4=new JComboBox<String>(languages);    
	    langField4.setBounds(D_X,D44_Y,D_WIDTH,D_HEIGHT); 
	    
	    final JComboBox<String> langField5=new JComboBox<String>(languages);    
	    langField5.setBounds(D_X,D45_Y,D_WIDTH,D_HEIGHT); 
	    
	    //Language degree level drop-down
	    String level[]= {"---","B1","B2","C1","C2"};
	    final JComboBox<String> levelField=new JComboBox<String>(level);    
	    levelField.setBounds(D4L_X,D4_Y,D4L_WIDTH,D_HEIGHT); 
	    f.add(levelField);
	    final JComboBox<String> levelField2=new JComboBox<String>(level);    
	    levelField2.setBounds(D4L_X,D42_Y,D4L_WIDTH,D_HEIGHT); 
	    
	    final JComboBox<String> levelField3=new JComboBox<String>(level);    
	    levelField3.setBounds(D4L_X,D43_Y,D4L_WIDTH,D_HEIGHT); 
	    
	    final JComboBox<String> levelField4=new JComboBox<String>(level);    
	    levelField4.setBounds(D4L_X,D44_Y,D4L_WIDTH,D_HEIGHT); 
	    
	    final JComboBox<String> levelField5=new JComboBox<String>(level);    
	    levelField5.setBounds(D4L_X,D45_Y,D4L_WIDTH,D_HEIGHT); 
	    

	    
	    
	    //add language field button
	    JButton buttonAddLang=new JButton("+");  
	    buttonAddLang.setBounds(LB_X,LB_Y,LB_WIDTH,LB_HEIGHT);
	    f.add(buttonAddLang);
	    buttonAddLang.addActionListener(new ActionListener() {  
	    	int i=1;
	        public void actionPerformed(ActionEvent e) {
	        	if (i==1) {
	        		f.add(langField2);
	        		f.add(levelField2);
	        	}
	        	else if (i==2) {
	        		f.add(langField3);
	        		f.add(levelField3);
	        	}
	        	else if (i==3) {
	        		f.add(langField4);
	        		f.add(levelField4);
	        	}
	        	else if (i==4) {
	        		f.add(langField5);
	        		f.add(levelField5);
	        		
	        	}
	        	i++;
	        	f.revalidate();
	        	f.repaint();
	        }
	    });
	        
	    
	    
	    //Next screen button
	    JButton buttonNext=new JButton("Get Tips");  
	    buttonNext.setBounds(NB_X,NB_Y,NB_WIDTH,NB_HEIGHT);
	    f.add(buttonNext);
	    buttonNext.addActionListener(new ActionListener() {  
	        public void actionPerformed(ActionEvent e) {
	        	//if both validation checks come true save data to user & move on, otherwise give out an error on the false ones
	        	if(ValidationCheck.CheckAVG(averageField.getText())&&ValidationCheck.CheckFailed(failedField.getText())) {
	        		//Save data to user
	        		stud.setAverageGrade(Double.parseDouble(averageField.getText()));
	        		stud.setnFailed(Integer.parseInt(failedField.getText()));
	        		int year=Integer.parseInt(yearField.getSelectedItem().toString().replace("+",""));
	        		stud.setAcademicYear(year);
	        		String clangs[]= {langField.getSelectedItem().toString(),langField2.getSelectedItem().toString(),
	        				langField3.getSelectedItem().toString(),langField4.getSelectedItem().toString(),langField5.getSelectedItem().toString()};
	        		String clevels[]= {levelField.getSelectedItem().toString(),levelField2.getSelectedItem().toString(),
	        				levelField3.getSelectedItem().toString(),levelField4.getSelectedItem().toString(),levelField5.getSelectedItem().toString()};
	        		HashMap<String, Integer> degrees = new HashMap<String, Integer>();
	        		for( int i = 0; i < 5; i++)
	        		{
	        		    if(clangs[i]!="---"&&clevels[i]!="---") {
	        		    	int lvl = 4;
	        		    	if (clevels[i]=="B1")
	        		    		lvl=1;
	        		    	else if (clevels[i]=="B2")
	        		    		lvl=2;
	        		    	else if (clevels[i]=="C1")
	        		    		lvl=3;
	        		    	degrees.put(clangs[i], lvl);
	        		    }
	        		}
	        		stud.setLangDegrees(degrees);
	        		//close window & call next one
	        		f.dispose();
		        	new UniversitySelectFrame(stud);
	        	}
	        	else {
	        		if (ValidationCheck.CheckAVG(averageField.getText()))
	        			f.remove(w1);
	        		else
	        			f.add(w1);
	        			
	        		if(ValidationCheck.CheckFailed(failedField.getText()))
	        			f.remove(w2);
	        		else
	        			f.add(w2);
	        		f.revalidate();
		        	f.repaint();
	        	}
	        	
	        }
	    });
	        
	    f.setVisible(true);  
	           
	}
}