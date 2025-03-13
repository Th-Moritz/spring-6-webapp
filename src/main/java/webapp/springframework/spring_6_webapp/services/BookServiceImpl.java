package webapp.springframework.spring_6_webapp.services;

import org.springframework.stereotype.Service;
import webapp.springframework.spring_6_webapp.domain.Book;
import webapp.springframework.spring_6_webapp.repositories.BookRepository;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }
}
