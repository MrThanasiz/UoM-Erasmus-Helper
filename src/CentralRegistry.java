import java.io.*;
import java.util.ArrayList;

import javax.swing.plaf.synth.Region;
public class CentralRegistry
{
	
		private static ArrayList<Student> s;
		private String username;
		private String password;
		
		public static boolean initializedList = false;
		static ArrayList<Student> studentList = new ArrayList<Student>();
		
		
		public static void desirializeUsers(){
			
			 
			 CreateFile cf = new CreateFile();
			 
			try {
				
				FileInputStream fileIn = new FileInputStream(cf.getFile());
		        ObjectInputStream in = new ObjectInputStream(fileIn);
		         
		   
		        s = (ArrayList<Student>)in.readObject();
		      
		        
		         //System.out.println("Deserialization worked"); 
				 //System.out.println(s.toString ()); 
				 
				initializedList = true;
				 
				 
		        in.close();
		        fileIn.close();
		         
		      } catch (IOException i) {
		    	  System.out.println("IOException is caught"); 
		         i.printStackTrace();
		         return;
		         
		      } catch (ClassNotFoundException c) {
		    	  
		         System.out.println("Student class not found");
		         c.printStackTrace();
		         return;
		      }
				
			   
				
			}
		


		
		public static void registerNewUser() {
			
			desirializeUsers();
			s.add(new Student( RegisterFrame.getID() , RegisterFrame.getPasswordRF()));
			serializeUsers();
			
			
		}


		public static void serializeUsers() {
		     String filename = "student.ser"; 
		     
		     // Serialization  
		        try
		        {    
		            //Saving of student in a file 
		            FileOutputStream file = new FileOutputStream(filename); 
		            ObjectOutputStream out = new ObjectOutputStream(file); 
		              
		            // Method for serialization of Student s
		            out.writeObject(s); 
		              
		            out.close(); 
		            file.close(); 
		              
		           // System.out.println("Serialization worked"); 
		           
		  
		        } 
		          
		        catch(IOException ex) 
		        { 
		            System.out.println("IOException is caught"); 
		        } 
		  
			
			
		}
		
		public static ArrayList<Student> getUsers(){
			
			return s;
			
		}
		
		
	}
	


