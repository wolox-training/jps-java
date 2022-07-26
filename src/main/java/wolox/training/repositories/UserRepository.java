package wolox.training.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wolox.training.models.Users;

@Repository
public interface UserRepository extends JpaRepository<Users,Long> {

    Users getUsersByName(String name);
}
