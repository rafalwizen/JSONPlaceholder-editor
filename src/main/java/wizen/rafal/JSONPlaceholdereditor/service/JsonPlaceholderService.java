package wizen.rafal.JSONPlaceholdereditor.service;

import org.json.simple.JSONArray;

public interface JsonPlaceholderService {

	public JSONArray getAllPosts();
	public void savePostsToFile(JSONArray posts);
}
