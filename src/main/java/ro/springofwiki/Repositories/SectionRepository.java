package ro.springofwiki.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.springofwiki.Models.Section;

public interface SectionRepository extends JpaRepository<Section, Integer> {

}
