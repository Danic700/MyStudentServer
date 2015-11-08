package student.manager;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

import student.data.Student;
import student.util.StudentHelper;

public class StudentRW {

	StudentHelper Util = new StudentHelper();
	String fileDirectory = "user.json";
	private static final Lock lock = new ReentrantLock();
	
	public Map<String, Student> doRead() //doRead is takes care of reading all the lines from user.json and returns it into a map using the jsonToMapStringStudent function
	{
		 Map<String, Student> Students = new HashMap<String, Student>();
		 Path path;
	    try {
	    	lock.lock();
	    	try{
	    		path = Paths.get(fileDirectory);
				String stringFromFile = java.nio.file.Files.lines(path).collect(Collectors.joining()); //to explain
				Students = Util.jsonToMapStringStudent(stringFromFile);
			} 
	    	finally {
	    		lock.unlock();	
	    	}
	    	
	    }
	    	catch (IOException e) {
				
			}
		 
		 return Students;
	}
	
	public void doWrite(Map<String, Student> Students) throws IOException //doWrite receives the map and and converts to JSON using mapStringStudentoJSon
	{
		String json;
		File f = new File(fileDirectory);
		lock.lock();
		   try{
		   if(f.createNewFile())			//if there is no file present one will be created
		   {
			   System.out.println("Success In creating new file!");
			   
		   }
		   else
		   {
			   System.out.println("File Already Exists");
		   }
		   
			   json = Util.mapStringStudentToJson(Students);
			   FileWriter writer = new FileWriter(fileDirectory);  
	    	   writer.write(json);  
	    	   writer.close();     	
		   }
		   finally{
    	   lock.unlock();
		   }
	}
}
