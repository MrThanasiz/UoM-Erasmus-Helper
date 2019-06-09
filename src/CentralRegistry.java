import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class CentralRegistry
{
	private static ArrayList<Department> departmentsList;
	
	private static ArrayList<Student> s;
	private String username;
	private String password;
		
	public static boolean initializedList = false;
		
		
	@SuppressWarnings("unchecked")
	public static void desirializeUsers(){
			
			 
		CreateFile cf = new CreateFile();
			 
		try {
				
			FileInputStream fileIn = new FileInputStream(cf.getFile());
		    ObjectInputStream in = new ObjectInputStream(fileIn);
		         
		   
		    s = (ArrayList<Student>)in.readObject();
		      
		        
		   // System.out.println("Deserialization worked"); 
				 
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
		
		public static ArrayList<Student> getStudents(){
			
			return s;
			
		}
		
		public static ArrayList<University> createUnis() {
			
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
		

		
		public static void createDep(ArrayList<University> uniList, ArrayList<Student> studentsList) {
			
			departmentsList = new ArrayList<>();
			
			Department informatics = new Department("Applied Informatics",uniList,studentsList,0,"dai");
			Department economics = new Department("Economics",uniList,studentsList,1,"eco");
			Department balkan = new Department("Balkan Studies",uniList,studentsList,2,"bal");
			Department businessadm = new Department("Business Admninistration",uniList,studentsList,3,"bus");
			Department accounting = new Department("Accounting & Finance",uniList,studentsList,4,"fin");
			Department european = new Department("European Studies",uniList,studentsList,5,"eur");
			Department educational = new Department("Educational & Social Policy",uniList,studentsList,6,"esp");
			Department music = new Department("Music Science & Art",uniList,studentsList,7,"mus");
			
			departmentsList.add(informatics);
			departmentsList.add(economics);
			departmentsList.add(balkan);
			departmentsList.add(businessadm);
			departmentsList.add(accounting);
			departmentsList.add(european);
			departmentsList.add(educational);
			departmentsList.add(music);
		}


		public static ArrayList<Department> getDepartments(){
			return departmentsList;
		}
		
	}
	


