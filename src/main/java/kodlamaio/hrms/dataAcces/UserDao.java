package kodlamaio.hrms.dataAcces;

import kodlamaio.hrms.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {
    User findById(int id);
}
