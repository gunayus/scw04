package org.springmeetup.scw04.store;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "animals-service")
public interface AnimalsServiceClient {

    @RequestMapping(method = RequestMethod.GET, value = "/all")
    List<Animal> getAnimals() ;


    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    Animal getAnimalById(@PathVariable("id") Integer id);
    
}
