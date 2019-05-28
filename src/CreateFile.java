import java.io.*;

public class CreateFile 
{
	public boolean fileExist = false ;
	public String file = "student.ser";
	
	
	public boolean checkFile() {
		
		
		File f = new File(file);
		if(f.exists() && !f.isDirectory()) { 
		    fileExist = true; 
		}
		return fileExist;
		
		
	}
	
	public void newFile() {
		//wait for input from user
		String username = null;
		String password = null;
		
		
		Student s = new Student(username , password);
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
	

