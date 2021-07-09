package kodlamaio.hrms.dataAcces;

import kodlamaio.hrms.entities.concretes.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageDao extends JpaRepository<Language,Integer> {
}
