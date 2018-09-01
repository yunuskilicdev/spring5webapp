package kilic.yunus.spring5webapp.bootstrap;

import kilic.yunus.spring5webapp.model.Author;
import kilic.yunus.spring5webapp.model.Book;
import kilic.yunus.spring5webapp.model.Publisher;
import kilic.yunus.spring5webapp.repository.AuthorRepository;
import kilic.yunus.spring5webapp.repository.BookRepository;
import kilic.yunus.spring5webapp.repository.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;

    private BookRepository bookRepository;

    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    public void initData() {
        Author eric = new Author("Eric", "Yesil");
        Book ddd = new Book("DDD", "1234");
        Publisher pub1 = new Publisher("pub1","add1");
        eric.getBooks().add(ddd);
        ddd.setPublisher(pub1);
        ddd.getAuthors().add(eric);
        ddd.setPublisher(pub1);

        Author rod = new Author("Rod", "Balans");
        Book noEJB = new Book("noEJB", "1234");
        Publisher pub2 = new Publisher("pub2","add2");
        rod.getBooks().add(noEJB);
        noEJB.setPublisher(pub2);
        noEJB.getAuthors().add(rod);
        noEJB.setPublisher(pub2);

        publisherRepository.save(pub1);
        publisherRepository.save(pub2);
        authorRepository.save(eric);
        authorRepository.save(rod);
        bookRepository.save(ddd);
        bookRepository.save(noEJB);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}
