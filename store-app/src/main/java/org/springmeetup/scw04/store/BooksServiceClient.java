package org.springmeetup.scw04.store;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("books-service")
public interface BooksServiceClient {

    @RequestMapping(method = RequestMethod.GET, value = "/all")
    List<Book> getBooks();
	
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    Book getBookById(@PathVariable("id") Integer id);

}
