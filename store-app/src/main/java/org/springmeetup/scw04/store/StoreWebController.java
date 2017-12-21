package org.springmeetup.scw04.store;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StoreWebController {

	@Autowired
	AnimalsService animalsService;

	@Autowired
	BooksServiceClient booksServiceClient;
	
	@GetMapping("/animals")
	public ModelAndView petshop() {		
		Map<String, Object> model = new LinkedHashMap<>();
		
		model.put("animals", animalsService.getAnimals());
		return new ModelAndView("animals", model);
	}
	
	@GetMapping("/books")
	public ModelAndView bookStore() {
		Map<String, Object> model = new LinkedHashMap<>();
		
		model.put("books", booksServiceClient.getBooks());
		return new ModelAndView("books", model);
	}
}
