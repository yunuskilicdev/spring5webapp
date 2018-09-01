package kilic.yunus.spring5webapp.bootstrap;

import kilic.yunus.spring5webapp.model.Author;
import kilic.yunus.spring5webapp.model.Book;
import kilic.yunus.spring5webapp.repository.AuthorRepository;
import kilic.yunus.spring5webapp.repository.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;

    private BookRepository bookRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public void initData() {
        Author eric = new Author("Eric", "Yesil");
        Book ddd = new Book("DDD", "1234", "Pub1");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        Author rod = new Author("Rod", "Balans");
        Book noEJB = new Book("noEJB", "1234", "Pub2");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

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
