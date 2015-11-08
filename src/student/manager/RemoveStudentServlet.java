package student.manager;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.data.Student;

public class RemoveStudentServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static Map<String, Student> studentMap;
	private static StudentRW readWrite = new StudentRW();
    static
    {	
        studentMap = new HashMap<String, Student>();
    }
    
    
    public RemoveStudentServlet() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		studentMap = readWrite.doRead();    //update the local map in case anything changed
		request.getQueryString();
	    String id=request.getParameter("id");
	    if(studentMap.containsKey(id) && studentMap.size()>0 && !id.isEmpty())  //we make sure that there is anything to delete
		{	
		    System.out.print("Removing Student By ID");
		    studentMap.remove(id);
		    readWrite.doWrite(studentMap);
		    StudentServlet.studentMap = readWrite.doRead();  //StudentServlets map gets updated right away in order to make the retrieval faster on it's end
			response.getWriter().append("Student Deleted");
		}
		else
		{
			response.getWriter().append("Nothing to delete or no ID entered");
			
		}
    
	}

}
