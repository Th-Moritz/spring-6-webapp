package webapp.springframework.spring_6_webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import webapp.springframework.spring_6_webapp.domain.Author;
import webapp.springframework.spring_6_webapp.domain.Book;
import webapp.springframework.spring_6_webapp.domain.Publisher;
import webapp.springframework.spring_6_webapp.repositories.AuthorRepository;
import webapp.springframework.spring_6_webapp.repositories.BookRepository;
import webapp.springframework.spring_6_webapp.repositories.PublisherRepository;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");

        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn("12345");

        Author ericSaved = authorRepository.save(eric);
        Book dddSaved = bookRepository.save(ddd);

        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Johnson");

        Book noEJB = new Book();
        noEJB.setTitle("J2EE Development without EJB");
        noEJB.setIsbn("67890");

        Author rodSaved = authorRepository.save(rod);
        Book noEJBSaved = bookRepository.save(noEJB);

        ericSaved.getBooks().add(dddSaved);
        rodSaved.getBooks().add(noEJBSaved);
        dddSaved.getAuthors().add(ericSaved);
        noEJBSaved.getAuthors().add(rodSaved);

        Publisher publisherA = new Publisher();
        publisherA.setPublisherName("Publisher A");
        publisherA.setAddress("Generic Street A");
        publisherA.setCity("Miami");
        publisherA.setState("Florida");
        publisherA.setZipCode("41900");

        Publisher publisherB = new Publisher();
        publisherB.setPublisherName("Publisher B");
        publisherB.setAddress("Generic Street B");
        publisherB.setCity("Houston");
        publisherB.setState("Texas");
        publisherB.setZipCode("19400");

        dddSaved.setPublisher(publisherA);
        noEJBSaved.setPublisher(publisherA);

        authorRepository.save(ericSaved);
        authorRepository.save(rodSaved);

        publisherRepository.save(publisherA);
        publisherRepository.save(publisherB);

        bookRepository.save(dddSaved);
        bookRepository.save(noEJBSaved);

        System.out.println("In Bootstrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());
        System.out.println("Publisher Count: " + publisherRepository.count());
    }
}
