import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class CentralRegistry
{
	private static ArrayList<Department> departmentsList;
	
	private static ArrayList<Student> students;
		
	public static boolean initializedList = false;
		
		
	@SuppressWarnings("unchecked")
	public static void desirializeUsers(){
			
			 
		CreateFile cf = new CreateFile();
			 
		try {
				
			FileInputStream fileIn = new FileInputStream(cf.getFile());
		    ObjectInputStream in = new ObjectInputStream(fileIn);
		    
		    
		    students = (ArrayList<Student>)in.readObject();
				 
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
	  
		  desirializeUsers(); 
		  ArrayList<Student> s = getStudents();
		  Student stud = new Student( RegisterFrame.getUsername() , RegisterFrame.getPasswordRF());
		  stud.setDepartment(RegisterFrame.getDep());
		  s.add(stud);
		  serializeUsers();
		  
		  return s.get(s.indexOf(stud));
	  }
	 


		public static void serializeUsers() {
			
		     String filename = "student.ser"; 
		     
		     // Serialization  
		     try{    
		    	 //Saving of student in a file 
		         FileOutputStream file = new FileOutputStream(filename); 
		         ObjectOutputStream out = new ObjectOutputStream(file); 
		              
		         // Method for serialization of Student s
		         out.writeObject(students); 
		              
		         out.close(); 
		         file.close(); 
		              
		         // System.out.println("Serialization worked"); 
		     }catch(IOException ex) {
		    	 
		        System.out.println("IOException is caught"); 
		     } 
		  
			
			
		}
		
		public static ArrayList<Student> getStudents(){
			
			return students;
			
		}
		
		private static ArrayList<University> createUnis() {
			
			String name;
			String town;
			String country;
			String language;
			String line = null;
			int nex = 0;
			boolean langRequired;
			ArrayList<University> uniList = new ArrayList<>();
			ArrayList<Integer> coop;
			University uni;
			File f = new File("Unis.txt");
			try {
				
				Scanner lineSc = new Scanner(f);
				
				
				
				while(lineSc.hasNext()) {
					
					line = lineSc.nextLine();
					@SuppressWarnings("resource")
					Scanner sc = new Scanner(line);
					sc.useDelimiter(",");
					
					name = sc.next();
					town = sc.next();
					country = sc.next();
					language = sc.next();
					langRequired = sc.nextBoolean();
					coop = new ArrayList<>();
					while(sc.hasNextInt()) {
						nex = sc.nextInt();
						coop.add(nex);
					}
					uni = new University(name,town,country,language,coop,langRequired);
					uniList.add(uni);
				}
				lineSc.close();
				
			}
			
			catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			return uniList;
			
		}
		

		
		public static void createDep() {
			
			departmentsList = new ArrayList<>();
			ArrayList<University> uniList = createUnis();
			
			departmentsList.add(new Department("Applied Informatics",uniList,0,"dai"));
			departmentsList.add(new Department("Economics",uniList,1,"eco"));
			departmentsList.add(new Department("Balkan Studies",uniList,2,"bal"));
			departmentsList.add(new Department("Business Admninistration",uniList,3,"bus"));
			departmentsList.add(new Department("Accounting & Finance",uniList,4,"fin"));
			departmentsList.add(new Department("European Studies",uniList,5,"eur"));
			departmentsList.add(new Department("Educational & Social Policy",uniList,6,"esp"));
			departmentsList.add(new Department("Music Science & Art",uniList,7,"mus"));
		}


		public static ArrayList<Department> getDepartments(){
			return departmentsList;
		}
		
		public static void assignStudsToDeps() {
			
			for(Student student: students) {
				departmentsList.get(departmentsList.indexOf(student.getDepartment())).addNewUser(student);
			}
		}
}