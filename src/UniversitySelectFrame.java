import javax.swing.*;    
import java.awt.event.*;
import java.util.HashMap;    
public class UniversitySelectFrame { 
	//Frame Options
	private static final int WIDTH=1280;
	private static final int HEIGHT=720;
	
	//"Choose university" Label
	private static final int L_X=WIDTH*52/100;
	private static final int L_Y=HEIGHT*10/100;
	
	//University 1,2,3 Labels
	private static final int CL_X=WIDTH*39/100;
	private static final int CL1_Y=HEIGHT*25/100;
	private static final int CL2_Y=HEIGHT*45/100;
	private static final int CL3_Y=HEIGHT*65/100;
	//University+Score Drop-downs
	private static final int C_X=WIDTH*40/100;
	private static final int C_WIDTH=WIDTH*15/100;
	private static final int C_HEIGHT=HEIGHT*5/100;
	private static final int C1_Y=HEIGHT*10/100;
	private static final int C2_Y=HEIGHT*20/100;
	private static final int C3_Y=HEIGHT*30/100;
	
	//Next button
	private static final int NB_X=WIDTH*60/100;
	private static final int NB_Y=HEIGHT*50/100;
	private static final int NB_WIDTH=WIDTH*10/100;
	private static final int NB_HEIGHT=HEIGHT*5/100;
	
	
	
	JFrame f;    
	UniversitySelectFrame(Student stud){
		//Frame Options
	    f=new JFrame("University Select");
	    f.setLayout(null);    
	    f.setSize(WIDTH,HEIGHT);    
	    
	    
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
	    
	    
	    
	    
	    //University+Score Drop-downs
	    String universities[]={"---","University of Czechia","University of Denmark","University of Italy","University of Netherlands","University of Poland","University of Portugal","University of Spain"};
		//TODO:
	    //String universities[]={} (gets possible universities for student)
	    //String languages[]={} for every university get's its language
	    //Double scores[]={} for every university get's its score
	    //then creates a "combined list" containing university + score
	    //user chooses & when next's pressed we save that choice
	    final JComboBox<String> uni1=new JComboBox<String>(universities);    
	    uni1.setBounds(C_X,C1_Y,C_WIDTH,C_HEIGHT); 
	    f.add(uni1);
	    final JComboBox<String> uni2=new JComboBox<String>(universities); 
	    uni2.setBounds(C_X,C2_Y,C_WIDTH,C_HEIGHT);
	    f.add(uni2);
	    final JComboBox<String> uni3=new JComboBox<String>(universities);  
	    uni3.setBounds(C_X,C3_Y,C_WIDTH,C_HEIGHT); 
	    f.add(uni3);
	    
	    //Next button
	    JButton buttonNext=new JButton("Get Tips");  
	    buttonNext.setBounds(NB_X,NB_Y,NB_WIDTH,NB_HEIGHT);
	    f.add(buttonNext);
	    buttonNext.addActionListener(new ActionListener() {  
	        public void actionPerformed(ActionEvent e) {
	        	HashMap<University, Double> scores= new HashMap<University, Double>();
	        	//TODO
	        	//fill scores :) 
	        	stud.setScores(scores);
	        	//f.dispose();
	        	//new tipsFrame(stud);
	        }
	    });
	        
	    f.setVisible(true);  
	     
	               
	}
}