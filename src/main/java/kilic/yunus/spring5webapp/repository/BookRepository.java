package kilic.yunus.spring5webapp.repository;

import kilic.yunus.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
