package org.springmeetup.scw04.animals;

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
public class AnimalsRestController {

	private Map<Integer, Animal> animalsMap = new HashMap<>();
	
	@PostConstruct
	public void init() {
		animalsMap.put(1, new Animal(1, "Cat"));
		animalsMap.put(2, new Animal(2, "Dog"));
		animalsMap.put(3, new Animal(3, "Duck"));
	}
	
	@RequestMapping(value = "/all")
	public Collection<Animal> getAll() {
		log.info("/all is running");
		
		return animalsMap.values();
	}

	@RequestMapping(value = "/{id}")
	public Animal checkedOut(@PathVariable("id") Integer id) {
		return animalsMap.get(id);
	}

}
