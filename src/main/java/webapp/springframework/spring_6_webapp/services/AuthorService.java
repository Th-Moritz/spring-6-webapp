package webapp.springframework.spring_6_webapp.services;

import org.springframework.stereotype.Service;
import webapp.springframework.spring_6_webapp.domain.Author;

@Service
public interface AuthorService {

    Iterable<Author>findAll();

}
