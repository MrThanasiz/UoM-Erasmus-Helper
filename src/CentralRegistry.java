import java.io.*;
import java.util.ArrayList;

public class CentralRegistry
{
	public static class CenteralRegistry 
	{
		
		
		//returns : true = file exists || false = file not exists
		//System.out.println(f.checkFile());
		
		public void desirializeUser(){
			CreateFile cf = new CreateFile();
			
			Student s = null;
			String username = null;
			String password = null;
			
			
			
			try {
				
				
				FileInputStream fileIn = new FileInputStream(cf.getFile());
		         ObjectInputStream in = new ObjectInputStream(fileIn);
		         s = (Student) in.readObject();
		         in.close();
		         fileIn.close();
		         
		      } catch (IOException i) {
		         i.printStackTrace();
		         return;
		      } catch (ClassNotFoundException c) {
		         System.out.println("Student class not found");
		         c.printStackTrace();
		         return;
		      }
				
			}
		}
		
		public Student getStudent() {
		
			
			Student s = null;
			
			
			return  s;
			
		}
	
	}
	


