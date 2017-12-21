package org.springmeetup.scw04.books;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class BooksRestController {

	private Map<Integer, Book> booksMap = new HashMap<>();
	
	@PostConstruct
	public void init() {
		booksMap.put(1, new Book(1, "Spring in Action"));
		booksMap.put(2, new Book(2, "Spring Boot in Action"));
		booksMap.put(3, new Book(3, "Spring Meetup in Istanbul"));
	}
	
	@RequestMapping(value = "/all")
	public Collection<Book> getAll() {
		log.info("/all is running");

		return booksMap.values();
	}

	@RequestMapping(value = "/{id}")
	public Book checkedOut(@PathVariable("id") Integer id) {
		return booksMap.get(id);
	}

}
