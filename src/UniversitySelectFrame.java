import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;    
public class UniversitySelectFrame { 
	//Frame Options
	private static final int WIDTH=1280;
	private static final int HEIGHT=720;
	
	//"Choose university" Label
	private static final int L_X=WIDTH*55/100;
	private static final int L_Y=HEIGHT*10/100;
	
	//Error msg
	private static final int ERR_X = WIDTH*59/100;
	private static final int ERR_Y = HEIGHT*15/100;
	
	//University 1,2,3 Labels
	private static final int CL_X=WIDTH*39/100;
	private static final int CL1_Y=HEIGHT*25/100;
	private static final int CL2_Y=HEIGHT*45/100;
	private static final int CL3_Y=HEIGHT*65/100;
	//University+Score Drop-downs
	private static final int C_X=WIDTH*40/100;
	private static final int C_WIDTH=WIDTH*25/100;
	private static final int C_HEIGHT=HEIGHT*5/100;
	private static final int C1_Y=HEIGHT*10/100;
	private static final int C2_Y=HEIGHT*20/100;
	private static final int C3_Y=HEIGHT*30/100;
	
	//Next button
	private static final int NB_X=WIDTH*70/100;
	private static final int NB_Y=HEIGHT*50/100;
	private static final int NB_WIDTH=WIDTH*10/100;
	private static final int NB_HEIGHT=HEIGHT*5/100;
	
	
	JFrame f;    
	UniversitySelectFrame(Student stud){
		//Frame Options
	    f=new JFrame("University Select");
	    f.setLayout(null);    
	    f.setSize(WIDTH,HEIGHT);   
	    f.setResizable(false);
		f.setLocationRelativeTo(null);
	    
	    
	    //"Choose University" Label
	    final JLabel cunilabel = new JLabel();          
	    cunilabel.setHorizontalAlignment(JLabel.TRAILING);  
	    cunilabel.setSize(L_X,L_Y);  
	    cunilabel.setText("Select 1 to 3 Universities");
	    f.add(cunilabel);
	    
	    //University 1,2,3 Labels
	    final JLabel uni1label = new JLabel();          
	    uni1label.setHorizontalAlignment(JLabel.TRAILING);  
	    uni1label.setSize(CL_X,CL1_Y);  
	    uni1label.setText("Choice #1:");
	    f.add(uni1label);
	    final JLabel uni2label = new JLabel();          
	    uni2label.setHorizontalAlignment(JLabel.TRAILING);  
	    uni2label.setSize(CL_X,CL2_Y);  
	    uni2label.setText("Choice #2:");
	    f.add(uni2label);
	    final JLabel uni3label = new JLabel();          
	    uni3label.setHorizontalAlignment(JLabel.TRAILING);  
	    uni3label.setSize(CL_X,CL3_Y);  
	    uni3label.setText("Choice #3:");
	    f.add(uni3label);
	    
	    final JLabel err = new JLabel("You must select atleast 1 University");          
	    err.setHorizontalAlignment(JLabel.TRAILING);  
	    err.setSize(ERR_X,ERR_Y);
	    err.setForeground(Color.red);
	    
	    
	    
	    //University+Score Drop-downs
	    final JComboBox<String> uni1=new JComboBox<String>();    
	    final JComboBox<String> uni2=new JComboBox<String>(); 
	    final JComboBox<String> uni3=new JComboBox<String>(); 
	    uni1.setBounds(C_X,C1_Y,C_WIDTH,C_HEIGHT); 
	    uni2.setBounds(C_X,C2_Y,C_WIDTH,C_HEIGHT);
	    uni3.setBounds(C_X,C3_Y,C_WIDTH,C_HEIGHT);
	    uni1.addItem("---");
	    uni2.addItem("---");
	    uni3.addItem("---");
	    ArrayList<University> unis=stud.getDepartment().getCooplist();
	    HashMap<String,University> strUni=new HashMap<String,University>();
	    for (University i:unis) {
			uni1.addItem(i.getName() +"   " +String.valueOf(Score.CalculateTotal(stud, i)));
			uni2.addItem(i.getName() +"   " +String.valueOf(Score.CalculateTotal(stud, i)));
			uni3.addItem(i.getName() +"   " +String.valueOf(Score.CalculateTotal(stud, i)));
			strUni.put(i.getName() +  "   " +String.valueOf(Score.CalculateTotal(stud, i)), i);
			//debug
			//System.out.println(i.getName() +"   " +String.valueOf(Score.CalculateTotal(stud, i)));
		}
	    f.add(uni1);
	    f.add(uni2);
	    f.add(uni3);
	    //Next button
	    JButton buttonNext=new JButton("Get Tips");  
	    buttonNext.setBounds(NB_X,NB_Y,NB_WIDTH,NB_HEIGHT);
	    f.add(buttonNext);
	    buttonNext.addActionListener(new ActionListener() {  
	        public void actionPerformed(ActionEvent e) {
	        	HashMap<University, Double> scores= new HashMap<University, Double>();
	        	//if no uni selected shows error msg
	        	if(uni1.getSelectedItem().toString()=="---"&&uni2.getSelectedItem().toString()=="---"&&uni3.getSelectedItem().toString()=="---") {
	        		f.add(err);
	        		f.revalidate();
		        	f.repaint();
	        	}
	        	else {
	        		if (strUni.get(uni1.getSelectedItem().toString())!=null)
	        			scores.put(strUni.get(uni1.getSelectedItem().toString()), Score.CalculateTotal(stud,strUni.get(uni1.getSelectedItem().toString())));
	        		if (strUni.get(uni2.getSelectedItem().toString())!=null)
	        			scores.put(strUni.get(uni2.getSelectedItem().toString()), Score.CalculateTotal(stud,strUni.get(uni2.getSelectedItem().toString())));
	        		if (strUni.get(uni3.getSelectedItem().toString())!=null)
	        			scores.put(strUni.get(uni3.getSelectedItem().toString()), Score.CalculateTotal(stud,strUni.get(uni3.getSelectedItem().toString())));
	        		stud.setScores(scores);
	        		CentralRegistry.serializeUsers();
		        	f.dispose();
		        	
		        	/*
		        	for(University uni:stud.getScores().keySet()) {
		        		System.out.println(Tips.getTipLEnglish(stud, uni));
		        		System.out.println(Tips.getTipLNative(stud, uni));
		        	}
		        	*/
		        	
		        	new MainFrame(stud);
	        	}
	        }
	    });
	        
	    f.setVisible(true); 
	}
}