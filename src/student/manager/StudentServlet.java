package student.manager;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import student.data.Student;

public class StudentServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
 
	private static final Gson gson;
	static Map<String, Student> studentMap;			//This Map is updated from the other classes so there is no need to read it a new from the disk each time this servlet is called
	private static StudentRW readWrite = new StudentRW();
    static
    {
    	gson = new Gson();
        studentMap = new HashMap<String, Student>();
        studentMap = readWrite.doRead();    //The map is initialized for the first time when we start the server
    }
    
    
    public StudentServlet() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getQueryString();
	    System.out.print("Searching for student");
	    String id=request.getParameter("id");		//parsing the query string..
		if(studentMap.containsKey(id) && studentMap.size()>0 && !id.isEmpty())    //We make sure that we actually got a valid ID from the client otherwise there is no point in checking
		{
			response.setContentType("application/json");	//The client gets back a JSON thanks to the GSON library
	    	response.setCharacterEncoding("UTF-8");
	    	response.getWriter().write(gson.toJson(studentMap.get(id)));
		    System.out.print("Student Found");

		}
		else
		{
		    System.out.print("No such student exists");
			response.getWriter().append("No Student FOUND or no ID entered");
		}
    
	}


}
