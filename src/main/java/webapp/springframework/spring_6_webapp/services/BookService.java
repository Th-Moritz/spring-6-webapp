package webapp.springframework.spring_6_webapp.services;

import org.springframework.stereotype.Service;
import webapp.springframework.spring_6_webapp.domain.Book;

@Service
public interface BookService {

    Iterable<Book> findAll();

}
