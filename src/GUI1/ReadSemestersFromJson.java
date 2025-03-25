package GUI1;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;
 
public class ReadSemestersFromJson
{
	private ArrayList<Semester> semesterList ;
	
	public ReadSemestersFromJson() {
		semesterList=new ArrayList<>();
		setData();
	}
    public void setData() 
    {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("JSON\\semester_info.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
 
            JSONObject jsonObj = (JSONObject)obj;
            parseSemesterObjects(jsonObj);//parse json objects into java unit list objects            
        } 
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } 
        catch (IOException e)
        {
            e.printStackTrace();
        } 
        catch (ParseException e) {
            e.printStackTrace();
        } 
        catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
 
    private void parseSemesterObjects(JSONObject semesterJson) 
    {
    	
    	JSONArray arrays = (JSONArray) semesterJson.get("semesters");
        for (Object object : arrays) {
        	//if(object instanceof Item)
        		semesterList.add(new Gson().fromJson(object.toString(), Semester.class));
        }
        
    }
    
    public ArrayList<Semester> getSemesterList(){
    	return semesterList;
    }
}