import javax.swing.*;    
import java.awt.event.*;    
public class UniversitySelectFrame { 
	//Frame Options
	private static final int WIDTH=1280;
	private static final int HEIGHT=720;
	
	//"Choose Country" Label
	private static final int L_X=WIDTH*21/40;
	private static final int L_Y=HEIGHT*1/10;
	
	//Country+Score Dropdowns
	private static final int C_X=WIDTH*8/20;
	private static final int C_WIDTH=WIDTH*3/20;
	private static final int C_HEIGHT=HEIGHT*1/20;
	private static final int C1_Y=HEIGHT*1/10;
	private static final int C2_Y=HEIGHT*2/10;
	private static final int C3_Y=HEIGHT*3/10;
	
	//Next button
	private static final int NB_X=WIDTH*6/10;
	private static final int NB_Y=HEIGHT*5/10;
	private static final int NB_WIDTH=WIDTH*1/10;
	private static final int NB_HEIGHT=HEIGHT*1/20;
	
	
	
	JFrame f;    
	UniversitySelectFrame(){
		//Frame Options
	    f=new JFrame("University Select");
	    f.setLayout(null);    
	    f.setSize(WIDTH,HEIGHT);    
	    
	    
	    //"Choose Country" Label
	    final JLabel label = new JLabel();          
	    label.setHorizontalAlignment(JLabel.TRAILING);  
	    label.setSize(L_X,L_Y);  
	    label.setText("Select 1 to 3 Universities");
	    f.add(label);
	    
	    //Country+Score Dropdowns
	    String languages[]={"University of Czechia","University of Denmark","University of Italy","University of Netherlands","University of Poland","University of Portugal","University of Spain"};
	    //Todo ^^ getcountries list,calcucalte score
	    JComboBox<String> jComboBox = new JComboBox<String>(languages);
		final JComboBox<String> country1=jComboBox;    
	    country1.setBounds(C_X,C1_Y,C_WIDTH,C_HEIGHT); 
	    f.add(country1);
	    final JComboBox<String> country2=jComboBox;    
	    country2.setBounds(C_X,C2_Y,C_WIDTH,C_HEIGHT);
	    f.add(country2);
	    final JComboBox<String> country3=jComboBox;    
	    country3.setBounds(C_X,C3_Y,C_WIDTH,C_HEIGHT); 
	    f.add(country3);
	    
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