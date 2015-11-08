package student.util;
import student.data.Student;
import java.lang.reflect.Type;
import java.util.*;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

public class StudentHelper {    //this is the utility class which utilizes the GSON library in order to convert from MAP to JSON and JSON to MAP.

	private static final Gson gson = new GsonBuilder().disableHtmlEscaping().create();
    private static final Type TT_mapStringStudent = new TypeToken<Map<String,Student>>(){}.getType(); // to explain

    public Map<String, Student> jsonToMapStringStudent(String json) {
        Map<String, Student> ret = new HashMap<String, Student>();
        if (json == null || json.isEmpty())
            return ret;
         return gson.fromJson(json, TT_mapStringStudent);
    }
    
    
    public String mapStringStudentToJson(Map<String, Student> map) {
        if (map == null)
            map = new HashMap<String, Student>();
         return gson.toJson(map);
    }
	
	
}
