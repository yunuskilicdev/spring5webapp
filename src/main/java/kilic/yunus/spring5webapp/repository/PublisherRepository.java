package kilic.yunus.spring5webapp.repository;

import kilic.yunus.spring5webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
