import java.io.*;

public class CreateFile 
{
	public boolean fileExist = false ;
	public String file = "student.ser";
	
	
	public boolean checkFile() {
		
		//returns : true = file exists || false = file not exists
		
		File f = new File(file);
		if(f.exists() && !f.isDirectory()) { 
		    fileExist = true; 
		}
		return fileExist;
		
		
	}
	
	public void newFile() {
		//wait for input from user
		
		Student s = CentralRegistry.registerNewUser();
		
	      try {
	         FileOutputStream fileOut =
	         new FileOutputStream( file );
	         
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(s);
	         out.close();
	         fileOut.close();
	         
	         //System.out.printf("Serialized data is saved in student.ser");
	         
	      } catch (IOException i) {
	         i.printStackTrace();
	      }
	   }
	
	public String getFile() {
		return file;
	}
	
	
	}
	

