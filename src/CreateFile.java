import java.io.*;
import java.util.ArrayList;

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
		
		
	      try {
	         FileOutputStream fileOut = new FileOutputStream( file );
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         
	         out.writeObject(new ArrayList<Student>());
	         
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
	

