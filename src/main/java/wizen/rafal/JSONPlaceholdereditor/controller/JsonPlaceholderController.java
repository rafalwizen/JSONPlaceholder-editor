package wizen.rafal.JSONPlaceholdereditor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import wizen.rafal.JSONPlaceholdereditor.service.JsonPlaceholderService;

@Controller
@RequestMapping("/")
public class JsonPlaceholderController {

	JsonPlaceholderService jsonPlaceholderEditorService;
	
	@Autowired
	public JsonPlaceholderController(JsonPlaceholderService theJsonPlaceholderService) {
		jsonPlaceholderEditorService = theJsonPlaceholderService;
	}
	
	@RequestMapping("/saveForm")
	public String showFormForSave() {
		return "save-form";
	}
	
	@RequestMapping("/savePosts")
	public String savePosts() {
		jsonPlaceholderEditorService.savePostsToFile(jsonPlaceholderEditorService.getAllPosts());
		return "save-form";
	}
}
