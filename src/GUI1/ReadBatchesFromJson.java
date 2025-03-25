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

public class ReadBatchesFromJson
{
	private ArrayList<Batch> batchList ;
	public ReadBatchesFromJson() {
		batchList=new ArrayList<>();
		setData();
	}
    public void setData() 
    {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("JSON\\batch_info.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
 
            JSONObject jsonObj = (JSONObject)obj;
            parseBatchObjects(jsonObj);//parse json objects into java unit list objects
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
 
    private void parseBatchObjects(JSONObject batchJson) 
    {
    	
    	JSONArray arrays = (JSONArray) batchJson.get("batches");
        for (Object object : arrays) {
        	//if(object instanceof Item)
        		batchList.add(new Gson().fromJson(object.toString(), Batch.class));
        }
        
    }
    
    public ArrayList<Batch> getBatchList(){
    	return batchList;
    }
}