package kilic.yunus.spring5webapp.repository;

import kilic.yunus.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
