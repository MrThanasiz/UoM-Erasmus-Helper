import java.util.*;
import java.nio.charset.StandardCharsets; 
import java.nio.file.*; 
import java.io.*;

public class ReadFilesIntoList 
{
	public static List<String> readFileInList(String fileName)
	{
		List<String> lines = null;
		try 
		{
			lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
			
		}
		catch (IOException e )
		{
			System.out.println("Error while reading file. ");
			e.printStackTrace();
		}
		return lines;
		
	}
	
	public static void main(String[] args) 
	  { 
		String directory = "D:\\Users\\Stef_Fok\\Documents\\UoM-Erasmus-Helper\\test.txt";
	    List dataInput = readFileInList( directory); 
	    
	  
	      Iterator<String> itr = dataInput.iterator(); 
	      while (itr.hasNext()) 
	    	  System.out.println(itr.next()); 
	  
	  
	    
	  }
}
