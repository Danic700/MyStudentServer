# MyStudentServer
Made with love.

This project consists of a Server written in Java and a simple Client written in HTML and JS.
The Server is comprised of 3 servlets, with each servlet being responsible for a different part of the functionality. 
StudentServlet  is responsible for looking up students with an ID.
AddStudentServlet is in charge of adding students to the class member studentMap and also writes them to a locally generated file named: user.json.
RemoveStudentServlet allows the removal of a student from the server by entering that students ID.
(Going to merge them into 1 servlet)

I thought it would be correct to save the students on the server with a HashMap on account of the retrieval speed being an important factor. Each time the map gets modified so does the file user.json, in case the server falls for some reason then all the data is still intact for the next time the server is up.
I used the Gson library to save the files onto the disk because it’s an easy library to work with and from previous projects I’ve had an easier time working with JSON’s when it comes to transferring data between the server and the client.
Each servlet only supports GET methods (as requested) and parses the query strings from the URL.
StudentRW is the class in charge of reading and writing the file to and from the disk. Each time an action is performed there is a lock to make sure no concurrency issues arise.
There are 3 different mappings for each servlet. 
Retrieval is just /StudentServlet?id=
Adding is /StudentServlet/add?id=&name=&gender=&grade=
Removal is /StudentServlet/remove?id=
