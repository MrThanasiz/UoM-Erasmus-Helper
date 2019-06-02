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
	private static final int D_X=WIDTH*8/20;
	private static final int D_WIDTH=WIDTH*3/20;
	private static final int D_HEIGHT=HEIGHT*1/20;
	private static final int D1_Y=HEIGHT*1/10;
	private static final int D2_Y=HEIGHT*2/10;
	private static final int D3_Y=HEIGHT*3/10;
	
	
	//Language field
	
	
	//Next button
	private static final int NB_X=WIDTH*6/10;
	private static final int NB_Y=HEIGHT*5/10;
	private static final int NB_WIDTH=WIDTH*1/10;
	private static final int NB_HEIGHT=HEIGHT*1/20;
	
	
	
	JFrame f;    
	InputDataFrame(){
		//Frame Options
	    f=new JFrame("Input Data");
	    f.setLayout(null);    
	    f.setSize(WIDTH,HEIGHT);    
	    
	    
	    //"Choose Country" Label
	    final JLabel label = new JLabel("Epelekse 1 ews 3 panepistimia");  
	    label.setHorizontalAlignment(JLabel.TRAILING);  
	    label.setSize(L_X,L_Y);
	    f.add(label);
	    
	    //Country+Score Dropdowns
	    String languages[]={"University of Czechia","University of Denmark","University of Italy","University of Netherlands","University of Poland","University of Portugal","University of Spain"};
	    //Todo ^^ getcountries list,calcucalte score
	    final JTextField country1=new JTextField("");    
	    country1.setBounds(D_X,D1_Y,D_WIDTH,D_HEIGHT); 
	    f.add(country1);
	    final JTextField country2=new JTextField("");   
	    country2.setBounds(D_X,D2_Y,D_WIDTH,D_HEIGHT);
	    f.add(country2);
	    final JTextField country3=new JTextField("");    
	    country3.setBounds(D_X,D3_Y,D_WIDTH,D_HEIGHT); 
	    f.add(country3);
	    
	    
	    
	    final JLabel l1 = new JLabel("Epelekse 1 ews 3 panepistimiafff");          
	    l1.setHorizontalAlignment(JLabel.TRAILING);  
	    l1.setSize(D_X,D1_Y);
	    f.add(l1);
	    
	    final JLabel l2 = new JLabel("Epelekse 1 ews 3 panepistimia");          
	    l2.setHorizontalAlignment(JLabel.TRAILING);  
	    l2.setSize(D_X,D2_Y);
	    f.add(l2);
	    
	    final JLabel l3 = new JLabel("Epelekse 1 ews 3 panepistimia");          
	    l3.setHorizontalAlignment(JLabel.TRAILING);  
	    l3.setSize(D_X,D3_Y);
	    f.add(l3);
	    
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