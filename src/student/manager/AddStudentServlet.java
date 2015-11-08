package student.manager;


import java.io.IOException;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.data.Student;

public class AddStudentServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private Student stud;
	private static Map<String, Student> studentMap;
	private static StudentRW readWrite = new StudentRW();
    static
    {
        studentMap = new HashMap<String, Student>();
    }
    
    
    public AddStudentServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id=request.getParameter("id");				//parsing the query string
		String fullName=request.getParameter("name");
		String gender=request.getParameter("gender");
		String grade=request.getParameter("grade");
		stud = new Student(id,fullName,gender,grade);
		studentMap = readWrite.doRead();				//update the local map in case anything changed
		
		if(studentMap.size()<=1000 && !studentMap.containsKey(stud.id) && !stud.id.isEmpty()) //if there is space in our map and this student doesnt appear already then we will commence with writing
		{
			studentMap.put(stud.id, stud);
		    readWrite.doWrite(studentMap);
		    StudentServlet.studentMap = readWrite.doRead();		//StudentServlets map gets updated right away in order to make the retrieval faster on it's end
		    response.getWriter().append("Student added");
		}
		else
		{
			response.getWriter().append("Maximum capacity or Already exists or no ID entered");
		}
    
	}

}
