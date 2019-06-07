import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CentralRegistry
{
	
	public static class NestedCentralRegistry 
	{}
		static Student s = null;
		String username = null;
		String password = null;
		
		public static boolean initializedList = false;
		static ArrayList<Student> studentList = new ArrayList<Student>();
		
		
		public static void desirializeUsers(){
			
			 
			 CreateFile cf = new CreateFile();
			 
			try {
				
				FileInputStream fileIn = new FileInputStream(cf.getFile());
		         ObjectInputStream in = new ObjectInputStream(fileIn);
		         
		   
		        s = (Student)in.readObject();
		      
		        
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
		


		
		public static Student registerNewUser() {
		
			Student s = new Student( HomeFrame.getUsername() , HomeFrame.getPasswordHF());
			return  s;
			
		}


		public static void serializeUser(Student s) {
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
		
		public static void getUsers(){
			
			
			CentralRegistry.desirializeUsers();
			studentList.add(s);
			
			
			
		}
		
		
	}
	


