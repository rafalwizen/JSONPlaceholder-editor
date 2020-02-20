package wizen.rafal.JSONPlaceholdereditor.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

@Service
public class JsonPlaceholderServiceImpl implements JsonPlaceholderService {

	@Override
	public JSONArray getAllPosts() {
		InputStreamReader readerPosts;
		JSONParser jsonParser = new JSONParser();
		try {
			URL urlPosts = new URL("https://jsonplaceholder.typicode.com/posts");
			readerPosts = new InputStreamReader(urlPosts.openStream());
			Object object = jsonParser.parse(readerPosts);
			JSONArray postsList = (JSONArray)object;
			return postsList;			
		} catch (IOException e){
			// to finish
		} catch (ParseException e) {
			e.printStackTrace();
			// to finish
		}
		return null;
	}

	@Override
	public void savePostsToFile(JSONArray posts) {
		
		for(int i = 0; i < posts.size(); i++) {
			try{
				File document = new File("./saved_files");
				document.mkdirs();
				
				JSONObject tempObject = (JSONObject)posts.get(i);
				FileWriter file = new FileWriter("saved_files/"+tempObject.get("id")+".json");
				file.write(tempObject.toJSONString());
				file.flush();
				file.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
		}
		
		
		
				
	}

}
