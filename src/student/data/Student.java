package student.data;

public class Student {
	
	 public String id;
	 public String name = "Some Name";		//default values just in case the client decides to send empty strings
	 public String gender = "Male/Female";
	 public String GPA = "69";

	    public Student(String id, String name, String gender, String GPA) {
	    	
	        this.id = id;
	        
	        if(!name.isEmpty()){			//in case the client sends empty strings then we stick with the default values
	        	this.name = name;
	        }
	        
	        if(!gender.isEmpty()){
	        	this.gender = gender;
	        }
	        if(!GPA.isEmpty())
	        {
	        	this.GPA = GPA;
	        }
	    }
	    
	    

}
