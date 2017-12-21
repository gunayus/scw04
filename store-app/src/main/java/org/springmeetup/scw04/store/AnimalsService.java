package org.springmeetup.scw04.store;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class AnimalsService {

	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	AnimalsServiceClient animalsServiceClient;
	
	@HystrixCommand(fallbackMethod = "fallback")
    public List<Animal> getAnimals() {
    	return restTemplate.getForObject("http://ANIMALS-SERVICE/all", List.class);
    }
	
    public Animal getAnimalById(Integer id) {
    	return animalsServiceClient.getAnimalById(id);
    }

    public List<Animal> fallback() {
    	List<Animal> result = new ArrayList<>();
    	result.add(new Animal(0, "foo"));
    	
    	return result;
    }
    
}
